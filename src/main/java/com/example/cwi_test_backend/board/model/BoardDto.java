package com.example.cwi_test_backend.board.model;

import lombok.Builder;
import lombok.Getter;

public class BoardDto {
    @Getter
    public static class BoardReq {
        private String title;
        private String content;
        private String writer;

    }
    public Board toString(BoardReq dto){
        return Board.builder()
                .title(dto.title)
                .content(dto.content)
                .writer(dto.writer)
                .build();
    }
}
