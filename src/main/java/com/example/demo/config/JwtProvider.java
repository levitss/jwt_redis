package com.example.demo.config;

import com.example.demo.domain.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Header;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Collections;
import java.util.Date;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class JwtProvider {
    private final JwtProperties jwtProperties;
    private final SecretKey key = Keys.secretKeyFor(SignatureAlgorithm.HS256);


    public String createToken(Date exp, User user) {
        Date now = new Date();
        Date expiry = new Date(now.getTime()  + exp.getTime());
        return Jwts.builder()
                .signWith(key)
                .header().type("jwt").and()
                .subject(user.getEmail())
                .expiration(expiry)
                .issuer(user.getUsername())
                .issuedAt(now)
                .claim("id",user.getId())
            .compact();
    }

    public boolean validToken(String token) {
        //조회가 되는가
        try {
            Claims payload = Jwts.parser().verifyWith(key).build().parseSignedClaims(token).getPayload();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Authentication getAuthentication(String token) {
        Claims claim = getClaim(token);
        Set<SimpleGrantedAuthority> authorities = Collections.singleton(new SimpleGrantedAuthority("USER"));
        return new UsernamePasswordAuthenticationToken(User.builder().email(claim.getSubject()),"",authorities);
    }

    public Claims getClaim(String token) {
        return Jwts.parser().verifyWith(key).build().parseSignedClaims(token).getPayload();
    }

}
