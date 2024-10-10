package com.sparta.scheduler.service;

import com.sparta.scheduler.dto.SchedulerRequestDto;
import com.sparta.scheduler.dto.SchedulerResponseDto;
import com.sparta.scheduler.entity.Scheduler;
import com.sparta.scheduler.repository.SchedulerRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchedulerService {

    private final JdbcTemplate jdbcTemplate;
    private final SchedulerRepository schedulerRepository;

    public SchedulerService(JdbcTemplate jdbcTemplate, SchedulerRepository schedulerRepository) {
        this.jdbcTemplate = jdbcTemplate;
        this.schedulerRepository = schedulerRepository;
    }

    //create
    public SchedulerResponseDto createScheduler(SchedulerRequestDto requestDto) {
        // RequestDto -> Entity
        Scheduler scheduler = new Scheduler(requestDto);

        //DB 저장
        SchedulerRepository schedulerRepository = new SchedulerRepository(jdbcTemplate);
        Scheduler saveScheduler = schedulerRepository.save(scheduler);

        // Entity -> ResponseDto
        SchedulerResponseDto schedulerResponseDto = new SchedulerResponseDto(scheduler);

        return schedulerResponseDto;
    }

    //read
    public List<SchedulerResponseDto> readScheduler() {
        //DB조회
        SchedulerRepository schedulerRepository = new SchedulerRepository(jdbcTemplate);
        return schedulerRepository.findAll();
    }

    //uddate
    public Long updateScheduler(Long id, SchedulerRequestDto requestDto) {
        SchedulerRepository schedulerRepository = new SchedulerRepository(jdbcTemplate);
        //해당 스케줄이 DB에 있는지 확인
        Scheduler scheduler = schedulerRepository.findById(id);
        if (scheduler != null) {
            // 스케줄러 내용 수정
            schedulerRepository.update(id, requestDto);
            return id;
        } else {
            throw new IllegalArgumentException("선택한 스케줄은 존재하지 않습니다.");
        }
    }

    //delete
    public Long deleteScheduler(Long id) {
        SchedulerRepository schedulerRepository = new SchedulerRepository(jdbcTemplate);
        //해당 스케줄이 DB에 있는지 확인
        Scheduler scheduler = schedulerRepository.findById(id);
        if (scheduler != null) {
            // 스케줄 삭제
            schedulerRepository.delete(id);

            return id;
        } else {
            throw new IllegalArgumentException("선택한 스케줄은 존재하지 않습니다.");
        }
    }
}
