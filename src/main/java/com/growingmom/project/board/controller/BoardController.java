package com.growingmom.project.board.controller;

import com.growingmom.project.board.entity.Board;
import com.growingmom.project.board.repository.BoardRepository;
import com.growingmom.project.exception.DataNotFoundException;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {

    private final BoardRepository boardRepository;

    @GetMapping("{boardId}")
    public Object getBoard(@PathVariable Long boardId){
        Board board = boardRepository.findById(boardId).orElseThrow(() -> new DataNotFoundException());
        return board;
    }
}
