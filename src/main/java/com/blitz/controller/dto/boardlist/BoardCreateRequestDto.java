package com.blitz.controller.dto.boardlist;

import com.blitz.domain.posts.Board;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@NoArgsConstructor
public class BoardCreateRequestDto {

    private String name;

    @Builder
    public BoardCreateRequestDto(String name) {
        this.name = name;
    }


    public Board toEntity() {
        return Board.builder()
                .name(name)
                .build();
    }
}
