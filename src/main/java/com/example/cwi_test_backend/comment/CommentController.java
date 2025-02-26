package com.example.cwi_test_backend.comment;

import com.example.cwi_test_backend.board.BoardService;
import com.example.cwi_test_backend.board.model.Board;
import com.example.cwi_test_backend.board.model.BoardDto;
import com.example.cwi_test_backend.comment.model.CommentDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/comment")
public class CommentController {
    private final CommentService commentService;

    @PostMapping("/regist")
    public BoardDto.BoardDtailsResp regist(@RequestBody CommentDto.CommentRequest dto) {
        return commentService.regist(dto);
    }
}
