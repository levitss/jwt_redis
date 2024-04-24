package com.example.demo.dto;

import lombok.Data;

@Data
public class UpdateArticleRequest {
    private String title;
    private String content;
}
