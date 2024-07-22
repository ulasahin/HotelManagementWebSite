package com.example.easystay.core.security.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.security.Key;
import java.util.Date;
import java.util.Map;

@Service
public class JwtService {
    @Value("${jwt.expiration}")
    private long EXPIRATION;

    @Value("${jwt.key}")
    private String SECRET_KEY;

    public String generateToken(String userName, Map<String, Object> extraClaims){
        String token = Jwts
                .builder()
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date (System.currentTimeMillis() + EXPIRATION))
                .claims(extraClaims)
                .subject(userName)
                .signWith(getSignKey())
                .compact();

        return token;
    }
    public boolean validateToken(String token){

        Date expirationDate = getClaimsFromToken(token).getExpiration();

        return expirationDate.after(new Date());
    }

    public String extractUserName(String token){

        return getClaimsFromToken(token).getSubject();
    }
    private Claims getClaimsFromToken(String token){
        SecretKey key = (SecretKey) getSignKey();
        return Jwts.parser()
                .verifyWith(key)
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    private Key getSignKey(){
        byte[] keyBytes = Decoders.BASE64URL.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
