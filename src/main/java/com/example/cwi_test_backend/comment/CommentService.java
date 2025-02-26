package com.example.cwi_test_backend.comment;

import com.example.cwi_test_backend.board.BoardRepository;
import com.example.cwi_test_backend.board.model.Board;
import com.example.cwi_test_backend.board.model.BoardDto;
import com.example.cwi_test_backend.comment.model.Comment;
import com.example.cwi_test_backend.comment.model.CommentDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final BoardRepository boardRepository;

    // board Idx
    public BoardDto.BoardDtailsResp regist(CommentDto.CommentRequest dto) {
        Board board= boardRepository.findById(dto.getBoardIdx()).get();
        Comment comment=Comment.builder()
                .writer(dto.getWriter())
                .content(dto.getContent())
                .board(board)
                .build();
        commentRepository.save(comment);

        board.addCommentCount();
        Board result = boardRepository.save(board);

        List<CommentDto.CommentResq> comments = new ArrayList<>();
        for (Comment c : result.getComments()) {
            comments.add(CommentDto.CommentResq.builder()
                    .idx(c.getIdx())
                    .writer(c.getWriter())
                    .content(c.getContent())
                    .build());
        }
        return BoardDto.BoardDtailsResp.builder()
                .writer(result.getWriter())
                .title(result.getTitle())
                .content(result.getContent())
                .comments(comments)
                .build();

    }
}
