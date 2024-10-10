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

    /**
     * http://localhost:8080/api/scheduler/1234
     */
//    @GetMapping("/{id}")
//    public SchedulerResponseDto getScheduler(Long id) {
//        Scheduler scheduler = schedulerList.get(id);
//        SchedulerResponseDto result = new SchedulerResponseDto(scheduler);
//        return result;
//    }

//    /**
//     * http://localhost:8080/api/user/jefflee
//     */
//    @GetMapping("/api/user/{username}")
//    public UserResponseDTO getUserByUsername(String username) {
//        User user = userList.get(username);
//        UserResponseDTO userResponseDTO = new UserResponseDTO(user);
//        return result;
//    }


//    {
//        1,
//                {"id": 1, "username": "username1", "contents": "contents1"}
//    },
//    {
//        2,
//                {"id": 2, "username": "username2", "contents": "contents2"}
//    },
//    {
//        1111,
//                {"id": 1111, "username": "username1111", "contents": "contents1111"}
//    },

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
