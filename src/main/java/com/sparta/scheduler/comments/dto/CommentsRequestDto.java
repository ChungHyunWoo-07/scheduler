package com.sparta.scheduler.comments.dto;

import lombok.Getter;

@Getter
public class CommentsRequestDto {

    /** 상위(부모)인 `Scheduler` */
    private Long schedulerId;

    /** 댓글 등록자 이름 */
    private String name;

    /** 댓글 내용 */
    private String content;
}
