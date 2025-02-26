package com.example.cwi_test_backend.comment.model;

import com.example.cwi_test_backend.board.model.Board;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    private String content;
    private String writer;

    @ManyToOne
    @JoinColumn(name = "board_idx", nullable = false)
    private Board board;
}
