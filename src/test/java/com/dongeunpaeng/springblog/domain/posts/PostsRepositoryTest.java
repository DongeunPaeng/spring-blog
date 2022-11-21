package com.dongeunpaeng.springblog.domain.posts;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;
import java.util.List;

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
    void findAll() {
        // given
        String title = "test title";
        String content = "test content";
        String author = "test author";

        postsRepository.save(Posts.builder()
                .title(title)
                .content(content)
                .author(author)
                .build());
        // when
        List<Posts> postsList = postsRepository.findAll();
        // then
        Posts posts = postsList.get(0);
        Assertions.assertThat(posts.getTitle()).isEqualTo(title);
        Assertions.assertThat(posts.getContent()).isEqualTo(content);
        Assertions.assertThat(posts.getAuthor()).isEqualTo(author);

         }
    @Test
    void RegisterBaseTimeEntity() {
        // given
        LocalDateTime now = LocalDateTime.of(2022, 11, 21, 0,0,0);
        String title = "test title";
        String content = "test content";
        String author = "test author";

        postsRepository.save(Posts.builder()
                .title(title)
                .content(content)
                .author(author)
                .build());
        // when
        List<Posts> postsList = postsRepository.findAll();
        // then
        Posts posts = postsList.get(0);
        System.out.println(">>>>>>>>>>>> createdDate="+posts.getCreatedDate()+", modifiedDate="+posts.getModifiedDate());
        Assertions.assertThat(posts.getCreatedDate().isAfter(now));
        Assertions.assertThat(posts.getModifiedDate().isAfter(now));
    }
}