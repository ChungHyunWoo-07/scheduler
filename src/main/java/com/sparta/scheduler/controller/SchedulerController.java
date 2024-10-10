package com.sparta.scheduler.controller;

import com.sparta.scheduler.dto.SchedulerRequestDto;
import com.sparta.scheduler.dto.SchedulerResponseDto;
import com.sparta.scheduler.service.SchedulerService;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/scheduler")
public class SchedulerController {

    private final JdbcTemplate jdbcTemplate;

    public SchedulerController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    //create
    @PostMapping
    public SchedulerResponseDto createScheduler(@RequestBody SchedulerRequestDto requestDto) {
        SchedulerService schedulerService = new SchedulerService(jdbcTemplate);
        return schedulerService.createScheduler(requestDto);
    }

    //read
    @GetMapping
    public List<SchedulerResponseDto> readScheduler() {
        SchedulerService schedulerService = new SchedulerService(jdbcTemplate);
        return schedulerService.readScheduler();
    }

    //uddate
    @PutMapping("/{id}")
    public Long updateScheduler(@PathVariable Long id, @RequestBody SchedulerRequestDto requestDto) {
        SchedulerService schedulerService = new SchedulerService(jdbcTemplate);
        return schedulerService.updateScheduler(id, requestDto);
    }
    //delete
    @DeleteMapping("/{id}")
    public Long deleteScheduler(@PathVariable Long id) {
        SchedulerService schedulerService = new SchedulerService(jdbcTemplate);
        return schedulerService.deleteScheduler(id);
    }
}
