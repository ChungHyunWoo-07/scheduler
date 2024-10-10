package com.sparta.scheduler.dto;

import com.sparta.scheduler.entity.Scheduler;
import lombok.Getter;

@Getter
public class SchedulerResponseDto {
    private Long id;
    private String username;
    private String contents;

    public SchedulerResponseDto(Scheduler scheduler) {
        this.id = scheduler.getId();
        this.username = scheduler.getUsername();
        this.contents = scheduler.getContents();
    }

    public SchedulerResponseDto(Long id, String username, String contents) {
        this. id = id;
        this.username = username;
        this.contents = contents;
    }
}
