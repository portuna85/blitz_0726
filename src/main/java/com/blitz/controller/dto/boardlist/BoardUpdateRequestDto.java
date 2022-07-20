package com.blitz.controller.dto.boardlist;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BoardUpdateRequestDto {

    private String name;

    @Builder
    public BoardUpdateRequestDto(String name) {
        this.name = name;
    }
}
