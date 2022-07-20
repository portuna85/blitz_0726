package com.blitz.controller;

import com.blitz.controller.dto.boardlist.BoardCreateRequestDto;
import com.blitz.domain.posts.Board;
import com.blitz.repository.BoardRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class BoardListApiControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private BoardRepository boardListRepository;

    @AfterEach
    public void tearDown() {
        boardListRepository.deleteAll();
    }

    @Test
    public void 게시판목록만들기() throws Exception {
        // given
        String name = "자유게시판";

        BoardCreateRequestDto requestDto = BoardCreateRequestDto.builder()
                .name(name)
                .build();
        String url = "http://localhost:" + port + "/api/v1/board";
        // when
        ResponseEntity<Long> responseEntity = restTemplate.postForEntity(url, requestDto, Long.class);

        // then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isGreaterThan(0L);

        List<Board> all = boardListRepository.findAll();

        assertThat(all.get(0).getName()).isEqualTo(name);

    }


}