package com.example.cwi_test_backend.board.model;

import com.example.cwi_test_backend.comment.model.Comment;
import com.example.cwi_test_backend.comment.model.CommentDto;
import lombok.Builder;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class BoardDto {
    @Getter
    public static class BoardReq {
        private String title;
        private String content;
        private String writer;

    }

    @Getter
    @Builder
    public static class BoardDtailsResp {
        private String title;
        private String content;
        private String writer;
        private List<CommentDto.CommentResq> comments;
    }

    @Getter
    @Builder
    public static class BoardListResq {
        private String title;
        private Long idx;
        private String writer;
        private Integer commentCount;
    }


    public Board toString(BoardReq dto){
        return Board.builder()
                .title(dto.title)
                .content(dto.content)
                .writer(dto.writer)
                .build();
    }
}
