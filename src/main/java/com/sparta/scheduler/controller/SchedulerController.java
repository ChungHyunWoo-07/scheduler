package com.sparta.scheduler.controller;

import com.sparta.scheduler.dto.SchedulerRequestDto;
import com.sparta.scheduler.dto.SchedulerResponseDto;
import com.sparta.scheduler.service.SchedulerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/scheduler")
public class SchedulerController {

    private final SchedulerService schedulerService;

    public SchedulerController(SchedulerService schedulerService) {
        this.schedulerService = schedulerService;
    }

    //create
    @PostMapping
    public SchedulerResponseDto createScheduler(@RequestBody SchedulerRequestDto requestDto) {
        return schedulerService.createScheduler(requestDto);
    }

    //read
    @GetMapping
    public List<SchedulerResponseDto> readScheduler() {
        return schedulerService.readScheduler();
    }

    //uddate
    @PutMapping("/{id}")
    public Long updateScheduler(@PathVariable Long id, @RequestBody SchedulerRequestDto requestDto) {
        return schedulerService.updateScheduler(id, requestDto);
    }
    //delete
    @DeleteMapping("/{id}")
    public Long deleteScheduler(@PathVariable Long id) {
        return schedulerService.deleteScheduler(id);
    }
}
