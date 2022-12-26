
package com.probando.segunda.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class TokenUtils {
    
    private final static String ACCESS_TOKEN_SECRET = "Umka8jy4DH2H67fCtNnekf4gDW63";
    private final static Long ACCESS_TOKEN_VALIDITY_SECONDS = 432_000L;
    
    public static String createToken(String nombre){
        Long expirationTime = ACCESS_TOKEN_VALIDITY_SECONDS * 1_000;
        Date expirationDate = new Date(System.currentTimeMillis()+expirationTime);
        
        Map<String, Object> extra = new HashMap<>();
        extra.put("nombre",nombre);
        
        return Jwts.builder()
                .setSubject(nombre)
                .setExpiration(expirationDate)
                .addClaims(extra)
                .signWith(Keys.hmacShaKeyFor(ACCESS_TOKEN_SECRET.getBytes()))
                .compact();
    }
    
    public static UsernamePasswordAuthenticationToken getAuthentication(String token){
        try {
            Claims claims = Jwts.parserBuilder()
                .setSigningKey(ACCESS_TOKEN_SECRET.getBytes())
                .build()
                .parseClaimsJws(token)
                .getBody();
        String nombre = claims.getSubject();
        return new UsernamePasswordAuthenticationToken(nombre,null,Collections.emptyList());
        } catch (JwtException e){
            return null;
        }
    }
}