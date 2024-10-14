package com.sparta.scheduler.service;

import com.sparta.scheduler.dto.SchedulerRequestDto;
import com.sparta.scheduler.dto.SchedulerResponseDto;
import com.sparta.scheduler.entity.Scheduler;
import com.sparta.scheduler.repository.SchedulerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SchedulerService {

    private final SchedulerRepository schedulerRepository;

    public SchedulerService(SchedulerRepository schedulerRepository) {
        this.schedulerRepository = schedulerRepository;
    }

    //create
    public SchedulerResponseDto createScheduler(SchedulerRequestDto requestDto) {
        // RequestDto -> Entity
        Scheduler scheduler = new Scheduler(requestDto);

        //DB 저장
        Scheduler saveScheduler = schedulerRepository.save(scheduler);

        // Entity -> ResponseDto
        SchedulerResponseDto schedulerResponseDto = new SchedulerResponseDto(scheduler);

        return schedulerResponseDto;
    }

    //read
    public List<SchedulerResponseDto> readScheduler() {
        //DB조회
        return schedulerRepository.findAll().stream().map(SchedulerResponseDto::new).toList();
    }

    //uddate
    @Transactional
    public Long updateScheduler(Long id, SchedulerRequestDto requestDto) {
        //해당 스케줄이 DB에 있는지 확인
        Scheduler scheduler = findScheduler(id);
            // 스케줄러 내용 수정
            scheduler.update(requestDto);

            return id;
    }

    //delete
    public Long deleteScheduler(Long id) {
        //해당 스케줄이 DB에 있는지 확인
        Scheduler scheduler = findScheduler(id);

            // 스케줄 삭제
        schedulerRepository.delete(scheduler);

        return id;
    }

    private Scheduler findScheduler(Long id) {
        return schedulerRepository.findById(id).orElseThrow(()-> // orElseThrow 어떻게 작동하는 건지?
                new IllegalArgumentException("선택한 메모는 존재하지 않습니다.")
        );
    }
}
