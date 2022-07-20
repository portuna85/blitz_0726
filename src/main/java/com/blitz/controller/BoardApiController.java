package com.blitz.controller;

import com.blitz.controller.dto.boardlist.BoardCreateRequestDto;
import com.blitz.controller.dto.boardlist.BoardListResponseDto;
import com.blitz.controller.dto.boardlist.BoardResponseDto;
import com.blitz.controller.dto.boardlist.BoardUpdateRequestDto;
import com.blitz.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class BoardApiController {

    private final BoardService boardService;

    @PostMapping("/api/v1/board")
    public Long create(@RequestBody BoardCreateRequestDto requestDto) {
        return boardService.create(requestDto);
    }

    @PutMapping("/api/v1/board/{id}")
    public Long update(@PathVariable Long id, @RequestBody BoardUpdateRequestDto requestDto) {
        return boardService.update(id, requestDto);
    }

    @DeleteMapping("/api/v1/board/{id}")
    public void delete(@PathVariable Long id) {
        boardService.delete(id);
    }

    @GetMapping("/api/v1/board/{id}")
    public BoardResponseDto findById(@PathVariable Long id) {
        return boardService.findById(id);
    }

    @GetMapping("/api/v1/board/list")
    public List<BoardListResponseDto> findAll() {
        return boardService.findAllDesc();
    }
}
