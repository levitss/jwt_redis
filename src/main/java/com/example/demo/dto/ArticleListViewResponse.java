package com.example.demo.dto;

import com.example.demo.domain.Article;

public record ArticleListViewResponse(Long id, String title, String content) {
    public ArticleListViewResponse(Long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    public ArticleListViewResponse(Article article) {
        this(article.getId(), article.getTitle(), article.getContent());
    }
}
