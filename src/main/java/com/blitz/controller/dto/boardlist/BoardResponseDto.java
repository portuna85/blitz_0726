package com.blitz.controller.dto.boardlist;

import com.blitz.domain.posts.Board;
import lombok.Getter;

@Getter
public class BoardResponseDto {

    private Long id;
    private String name;

    public BoardResponseDto(Board entity) {
        this.id = entity.getId();
        this.name = entity.getName();
    }
}
