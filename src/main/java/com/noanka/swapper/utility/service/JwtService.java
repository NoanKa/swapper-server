package com.noanka.swapper.utility.service;

import com.noanka.swapper.module.profile.repository.entity.UserEntity;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;

@Service
@Profile("!local")
public class JwtService {
    @Value("${spring.security.oauth2.resourceserver.jwt.secret}")
    private String SECRET_KEY;
    @Value("${jwt.access.expiration}")
    private long ACCESS_EXPIRATION;
    @Value("${jwt.refresh.expiration}")
    private long REFRESH_EXPIRATION;

    private SecretKey getSignKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    public String generateAccessToken(UserEntity user) {
        return Jwts.builder()
                .subject(user.getId().toString())
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + ACCESS_EXPIRATION * 1000L)) // 1 hour
                .signWith(getSignKey())
                .compact();
    }

    public String generateRefreshToken(UserEntity user) {
        return Jwts.builder()
                .subject(user.getId().toString())
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + REFRESH_EXPIRATION * 1000L)) // 1 hour
                .signWith(getSignKey())
                .compact();
    }
}
