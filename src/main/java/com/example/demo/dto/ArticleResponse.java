package com.example.demo.dto;

import com.example.demo.domain.Article;

public record ArticleResponse(String title, String content) {
    public ArticleResponse(String title, String content) {
        this.title = title;
        this.content = content;
    }
    public ArticleResponse(Article article) {
        this(article.getTitle(),article.getContent());
    }


}
