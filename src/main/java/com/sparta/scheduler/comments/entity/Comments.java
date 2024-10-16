package com.sparta.scheduler.comments.entity;

import com.sparta.scheduler.comments.dto.CommentsRequestDto;
import com.sparta.scheduler.scheduler.entity.Timestamped;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "comments")
public class Comments extends Timestamped {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long num;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "content", nullable = false, length = 500)
    private String content;

    @Column(name = "scheduler_id", nullable = false)
    private Long schedulerId;

    public Comments(CommentsRequestDto requestDto) {
        this.name = requestDto.getName();
        this.content = requestDto.getContent();
        this.schedulerId = requestDto.getSchedulerId();
    }

    public void update(CommentsRequestDto requestDto) {
        this.name = requestDto.getName();
        this.content = requestDto.getContent();
        this.schedulerId = requestDto.getSchedulerId();
    }
}
