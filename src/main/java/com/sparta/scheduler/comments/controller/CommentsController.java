package com.sparta.scheduler.comments.controller;

import com.sparta.scheduler.comments.dto.CommentsRequestDto;
import com.sparta.scheduler.comments.dto.CommentsResponseDto;
import com.sparta.scheduler.comments.service.CommentsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/scheduler/comments")
public class CommentsController {

    private final CommentsService commentsService;

    public CommentsController(CommentsService commentsService) {
        this.commentsService = commentsService;
    }

    @PostMapping
    public CommentsResponseDto createComments(@RequestBody CommentsRequestDto requestDto) {
        return commentsService.createComments(requestDto);
    }

    @GetMapping
    public List<CommentsResponseDto> readComments() {
        return commentsService.readComments();
    }

    @PutMapping("/{num}")
    public Long updateComments(@PathVariable Long num, @RequestBody CommentsRequestDto requestDto){
        return commentsService.updateComments(num, requestDto);
    }

    @DeleteMapping("/{num}")
    public Long deleteComments(@PathVariable Long num) {
        return commentsService.deleteComments(num);
    }

}
