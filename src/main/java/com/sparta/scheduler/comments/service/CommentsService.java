package com.sparta.scheduler.comments.service;

import com.sparta.scheduler.comments.dto.CommentsRequestDto;
import com.sparta.scheduler.comments.dto.CommentsResponseDto;
import com.sparta.scheduler.comments.entity.Comments;
import com.sparta.scheduler.comments.repository.CommentsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentsService {

    private final CommentsRepository commentsRepository;

    public CommentsService(CommentsRepository commentsRepository) {
        this.commentsRepository = commentsRepository;
    }

    //create
    public CommentsResponseDto createComments(CommentsRequestDto requestDto) {
        Comments comments = new Comments(requestDto);

        Comments saveComments = commentsRepository.save(comments);

        CommentsResponseDto commentsResponseDto = new CommentsResponseDto(comments);

        return commentsResponseDto;
    }

    //read
    public List<CommentsResponseDto> readComments() {
        return commentsRepository.findAllByOrderByModifiedAtDesc().stream().map(CommentsResponseDto::new).toList();
    }

    //update
    public Long updateComments(Long num, CommentsRequestDto requestDto) {
        Comments comments = findComments(num);
        comments.update(requestDto);
        return num;

    }
    //delete
    public Long deleteComments(Long num) {
        Comments comments = findComments(num);
        commentsRepository.delete(comments);
        return num;
    }

    private Comments findComments(Long num) {
        return commentsRepository.findById(num).orElseThrow(()->
            new IllegalArgumentException("선택한 댓글은 존재하지 않습니다.")
        );
    }
}
