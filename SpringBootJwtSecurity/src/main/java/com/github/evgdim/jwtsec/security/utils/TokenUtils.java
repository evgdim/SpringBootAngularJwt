package com.github.evgdim.jwtsec.security.utils;

import java.util.Date;

import org.apache.commons.lang3.time.DateUtils;

import com.github.evgdim.jwtsec.security.model.JwtPrincipal;
import com.github.evgdim.jwtsec.security.model.UserLoginVO;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public abstract class TokenUtils {
    public static final String AUTH_HEADER = "Authorization";
    public static final String SECRET_KEY = "secretkey";

    private TokenUtils(){}

    public static JwtPrincipal parseToken(final String authHeader){
        final String token = authHeader.substring(7); // The part after "Bearer ";

        final Claims claims = Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();

        JwtPrincipal principal = new JwtPrincipal("todoGetFromToken", claims);
        return principal;
    }

    public static String generateToken(final UserLoginVO login){
        Date now = new Date();
        String token = Jwts.builder()
                .setSubject(login.getUsername())
                .claim("role", "USER")
                .setIssuedAt(now)
                .setExpiration(DateUtils.addMinutes(now, 30))
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
        return token;
    }
}
