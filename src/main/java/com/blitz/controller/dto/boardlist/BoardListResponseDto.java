package com.blitz.controller.dto.boardlist;

import com.blitz.domain.posts.Board;
import lombok.Getter;

@Getter
public class BoardListResponseDto {
    private Long id;
    private String name;

    public BoardListResponseDto(Board entity) {
        this.id = entity.getId();
        this.name = entity.getName();
    }
}
