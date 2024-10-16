package com.sparta.scheduler.comments.dto;

import com.sparta.scheduler.comments.entity.Comments;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CommentsResponseDto {
    private Long num;
    private String name;
    private String content;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    public CommentsResponseDto(Comments comments) {
        this.num = comments.getNum();
        this.name = comments.getName();
        this.content = comments.getContent();
        this.createdAt = comments.getCreatedAt();
        this.modifiedAt = comments.getModifiedAt();
    }
}
