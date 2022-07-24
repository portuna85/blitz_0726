package com.blitz.repository;

import com.blitz.domain.Posts;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

@Slf4j
@ExtendWith(SpringExtension.class)
@SpringBootTest
class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @AfterEach
    public void cleanUp() {
        postsRepository.deleteAll();
    }

    @Test
    public void 게시글저장_불러오기() throws Exception {
        // given
        String title = "title";
        String content = "content";


        postsRepository.save(Posts.builder()
                .title(title)
                .content(content)
                .author("portuna85@gmail.com")
                .build());

        // when
        List<Posts> postsList = postsRepository.findAll();


        // then
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);


    }

    @Test
    public void BaseTimeEntity_등록() throws Exception {
        // given
        LocalDateTime now = LocalDateTime.of(2022, 07, 21, 21, 34, 22);
        postsRepository.save(Posts.builder()
                .title("title")
                 .content("content")
                .author("author")
                .build());


        // when
        List<Posts> postsList = postsRepository.findAll();

        // then
        Posts posts = postsList.get(0);

        log.info("createdDate = {}, modifiedDate = {}", posts.getCreatedDate(), posts.getModifiedDate());

    }
}