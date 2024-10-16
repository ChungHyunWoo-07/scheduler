package com.sparta.scheduler.scheduler.dto;

import com.sparta.scheduler.scheduler.entity.Scheduler;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class SchedulerResponseDto {
    private Long id;
    private String username;
    private String contents;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    public SchedulerResponseDto(Scheduler scheduler) {
        this.id = scheduler.getId();
        this.username = scheduler.getUsername();
        this.contents = scheduler.getContents();
        this.createdAt = scheduler.getCreatedAt();
        this.modifiedAt = scheduler.getModifiedAt();
    }
}
