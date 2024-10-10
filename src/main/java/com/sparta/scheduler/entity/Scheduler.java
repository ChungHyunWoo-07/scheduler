package com.sparta.scheduler.entity;

import com.sparta.scheduler.dto.SchedulerRequestDto;
import jakarta.persistence.*;
import lombok.Generated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Scheduler")
@Getter
@NoArgsConstructor
@Setter

public class Scheduler {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "username", nullable = false)
    private String username;
    @Column(name = "contents", nullable = false, length = 500)
    private String contents;

    public Scheduler(SchedulerRequestDto requestDto) {
    }

    public void update(SchedulerRequestDto requestDto) {
    }
}

