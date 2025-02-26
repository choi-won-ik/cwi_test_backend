package com.example.cwi_test_backend.comment.model;

import lombok.Getter;

public class CommentDto {
    @Getter
    public static class CommentRequest {
        private String content;
        private String writer;
    }

    public Comment toString(CommentRequest dto){
        return Comment.builder()
                .writer(dto.writer)
                .content(dto.content)
                .build();
    }
}
