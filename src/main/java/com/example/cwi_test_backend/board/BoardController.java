package com.example.cwi_test_backend.board;

import com.example.cwi_test_backend.board.model.Board;
import com.example.cwi_test_backend.board.model.BoardDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {
    private final BoardService boardService;

    @GetMapping("/list")
    public List<Board> list() {
        return boardService.list();
    }

    @GetMapping("/details/{boardIdx}")
    public BoardDto.BoardDtailsResp details(@PathVariable Long boardIdx) {
        return boardService.details(boardIdx);
    }
}
