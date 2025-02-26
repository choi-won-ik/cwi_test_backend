package com.example.cwi_test_backend.comment.model;

import lombok.Builder;
import lombok.Getter;

public class CommentDto {
    @Getter
    public static class CommentRequest {
        private Long boardIdx;
        private String content;
        private String writer;
    }

    @Getter
    @Builder
    public static class CommentResq {
        private Long idx;
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
