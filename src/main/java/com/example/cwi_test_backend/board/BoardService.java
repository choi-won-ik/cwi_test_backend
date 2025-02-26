package com.example.cwi_test_backend.board;

import com.example.cwi_test_backend.board.model.Board;

import com.example.cwi_test_backend.board.model.BoardDto;
import com.example.cwi_test_backend.comment.CommentRepository;
import com.example.cwi_test_backend.comment.model.Comment;
import com.example.cwi_test_backend.comment.model.CommentDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;

    @Transactional(readOnly = true)
    public List<Board> list() {
        return boardRepository.findAll();
    }

    @Transactional(readOnly = true)
    public BoardDto.BoardDtailsResp details(Long idx) {
        Optional<Board> op = boardRepository.findById(idx);
        if (op.isPresent()) {
            Board board = op.get();
            List<CommentDto.CommentResq> comments = new ArrayList<>();
            for (Comment comment : board.getComments()) {
                comments.add(CommentDto.CommentResq.builder()
                        .idx(comment.getIdx())
                        .writer(comment.getWriter())
                        .content(comment.getContent())
                        .build());
            }
            return BoardDto.BoardDtailsResp.builder()
                    .writer(board.getWriter())
                    .title(board.getTitle())
                    .content(board.getContent())
                    .comments(comments)
                    .build();
        }

        return null;
    }

    @Transactional
    public Board regist(BoardDto.BoardReq dto) {
        return Board.builder()
                .title(dto.getTitle())
                .writer(dto.getWriter())
                .content(dto.getContent())
                .commentCount(0)
                .build();
    }
}
