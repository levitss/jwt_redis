package com.example.demo.dto;

import com.example.demo.domain.Article;

import java.time.LocalDateTime;

public record ArticleViewResponse(Long id, String title, String content, String author, LocalDateTime createdAt) {
    public ArticleViewResponse(Long id, String title, String content, String author, LocalDateTime createdAt) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;
        this.createdAt = createdAt;
    }

    public ArticleViewResponse(Article article) {
        this(article.getId(), article.getTitle(), article.getContent(), article.getAuthor(), article.getCreatedAt());
    }

}
