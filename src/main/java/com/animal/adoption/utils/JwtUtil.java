package com.animal.adoption.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtUtil {
    public static final String TOKEN_HEADER = "Authorization";
    private static final String SECRET_KEY = "mySecretKey"; // 请使用更安全的密钥
    private static final long ONE_DAY_IN_MILLIS = 24 * 60 * 60 * 1000; // 1天

    public static String generateToken(String username, String role) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("role", role);
        return createToken(claims, username);
    }

    private static String createToken(Map<String, Object> claims, String subject) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + ONE_DAY_IN_MILLIS);

        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS512, SECRET_KEY)
                .compact();
    }

    // 验证 token
    public static boolean validateToken(String token, String username) {
        final String extractedUsername = extractUsername(token);
        return (extractedUsername.equals(username) && !isExpired(token));
    }

    // extract username from token
    public static String extractUsername(String token) {
        return extractAllClaims(token).getSubject();
    }

    public static String extractRole(String token) {
        return (String)extractAllClaims(token).get("role");
    }

    // 检查 token 是否过期
    public static boolean isExpired(String token) {
        return extractAllClaims(token).getExpiration().before(new Date());
    }

    // 提取所有声明
    private static Claims extractAllClaims(String token) {
        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
    }
}
