package com.noanka.swapper.module.auth.controller.http.dto;

import java.util.UUID;

public class TokenDto {
    private UUID userId;
    private String accessToken;
    private String refreshToken;
    private Long accessTokenExpire;
    private Long refreshTokenExpire;

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public Long getAccessTokenExpire() {
        return accessTokenExpire;
    }

    public void setAccessTokenExpire(Long accessTokenExpire) {
        this.accessTokenExpire = accessTokenExpire;
    }

    public Long getRefreshTokenExpire() {
        return refreshTokenExpire;
    }

    public void setRefreshTokenExpire(Long refreshTokenExpire) {
        this.refreshTokenExpire = refreshTokenExpire;
    }
}
