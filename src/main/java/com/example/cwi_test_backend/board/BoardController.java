package com.example.cwi_test_backend.board;

import com.example.cwi_test_backend.board.model.Board;
import com.example.cwi_test_backend.board.model.BoardDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {
    private final BoardService boardService;

    @GetMapping("/list")
    public List<BoardDto.BoardListResq> list() {
        return boardService.list();
    }

    @GetMapping("/details/{boardIdx}")
    public BoardDto.BoardDtailsResp details(@PathVariable Long boardIdx) {
        return boardService.details(boardIdx);
    }

    @PostMapping("/regist")
    public Board regist(@RequestBody BoardDto.BoardReq dto) {
        return boardService.regist(dto);
    }
}
