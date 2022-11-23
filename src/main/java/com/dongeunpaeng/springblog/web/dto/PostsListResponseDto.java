package com.dongeunpaeng.springblog.web.dto;

import com.dongeunpaeng.springblog.domain.posts.Posts;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class PostsListResponseDto {
    private Long id;
    private String title;
    private String author;
    private LocalDateTime moidifiedDate;

    // TODO: 여기부터...
    public PostsListResponseDto(Posts entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.author = entity.getAuthor();
        this.moidifiedDate = entity.getModifiedDate();
    }
}
