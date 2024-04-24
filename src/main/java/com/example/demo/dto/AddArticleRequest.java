package com.example.demo.dto;

import com.example.demo.domain.Article;
import lombok.Data;

@Data
public class AddArticleRequest {
    private String title;
    private String content;

    public Article toEntity(String author) {
        return Article.builder()
                .author(author)
                .content(content)
                .title(title)
                .build();
    }
}
