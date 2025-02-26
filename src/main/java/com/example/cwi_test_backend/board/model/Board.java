package com.example.cwi_test_backend.board.model;

import com.example.cwi_test_backend.comment.model.Comment;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Idx;

    private String title;
    private String content;
    private String writer;

    @OneToMany(mappedBy = "board")
    private List<Comment> comments=new ArrayList<>();

    private int commentCount;

    public void addCommentCount() {
        this.commentCount = this.commentCount + 1;
    }

}
