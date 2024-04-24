package com.example.demo.dto;

public record CreateAccessTokenResponse(String accessToken) {
    public CreateAccessTokenResponse(String accessToken) {
        this.accessToken = accessToken;
    }
}
