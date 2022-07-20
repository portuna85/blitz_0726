package com.blitz.service;

import com.blitz.controller.dto.boardlist.BoardCreateRequestDto;
import com.blitz.controller.dto.boardlist.BoardListResponseDto;
import com.blitz.controller.dto.boardlist.BoardResponseDto;
import com.blitz.controller.dto.boardlist.BoardUpdateRequestDto;
import com.blitz.domain.posts.Board;
import com.blitz.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
@Slf4j
public class BoardService {

    private final BoardRepository boardRepository;

    @Transactional
    public Long create(BoardCreateRequestDto requestDto) {
        return boardRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, BoardUpdateRequestDto requestDto) {
        Board boardList = boardRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시목록이 없습니다. id = " + id));
        boardList.update(requestDto.getName());
        return id;
    }

    @Transactional
    public void delete(Long id) {
        Board board = boardRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시판이 없습니다 id = " + id));

        boardRepository.delete(board);
    }

    @Transactional
    public BoardResponseDto findById(Long id) {
        Board entity = boardRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시목록이 없습니다 id = " + id));
        return new BoardResponseDto(entity);
    }

    @Transactional(readOnly = true)
    public List<BoardListResponseDto> findAllDesc() {
        return boardRepository.findAllDesc().stream()
                .map(BoardListResponseDto::new)
                .collect(Collectors.toList());
    }
}
