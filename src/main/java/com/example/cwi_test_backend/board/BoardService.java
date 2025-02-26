package com.example.cwi_test_backend.board;

import com.example.cwi_test_backend.board.model.Board;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;

    @Transactional(readOnly = true)
    public List<Board> list() {
        return boardRepository.findAll();
    }
}
