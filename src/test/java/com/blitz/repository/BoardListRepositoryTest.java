package com.blitz.repository;

import com.blitz.domain.posts.Board;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class BoardListRepositoryTest {

    @Autowired
    BoardRepository boardListRepository;
    
    @AfterEach
    void tearDown() {
        boardListRepository.deleteAll();
    }
    
    @Test
    public void 게시글저장() throws Exception {
        // given

        String name = "자유계시판";
        boardListRepository.save(Board.builder()
                        .name(name)
                .build());
        
        // when
        List<Board> boardListRepositoryAll = boardListRepository.findAll();

        // then
        Board boardList = boardListRepositoryAll.get(0);

        assertThat(boardList.getName()).isEqualTo(name);
    }
    
}