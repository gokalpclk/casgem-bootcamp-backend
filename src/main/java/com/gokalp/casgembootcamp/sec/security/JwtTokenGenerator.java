package com.gokalp.casgembootcamp.sec.security;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;

import java.util.Date;

/**
 * @author Gokalp on 3.01.2023
 * @project casgem-bootcamp
 */
public class JwtTokenGenerator {

    @Value("${jwt.app.key}")
    private String APP_KEY;

    @Value("${jwt.expire.time}")
    private Long EXPIRE_TIME;

    public String generateJwtToken(Authentication authentication) {
        JwtUserDetails jwtUserDetails = (JwtUserDetails) authentication.getPrincipal();
/*      ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json;
        try {
            json = ow.writeValueAsString(jwtUserDetails);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }*/
        Date expireDate = new Date(new Date().getTime() + EXPIRE_TIME);
        String token = Jwts.builder()
                .setSubject(Long.toString(jwtUserDetails.getId()))
                .setIssuedAt(new Date())
                .setExpiration(expireDate)
                .signWith(SignatureAlgorithm.HS512, APP_KEY)
                .compact();
        return token;
    }

    public Long findUserIdByToken(String token) {

        Jws<Claims> claimsJws = parseToken(token);
        String userIdStr = claimsJws
                .getBody()
                .getSubject();
        return Long.parseLong(userIdStr);
    }

    private Jws<Claims> parseToken(String token) {
        Jws<Claims> claimsJws = Jwts.parser()
                .setSigningKey(APP_KEY)
                .parseClaimsJws(token);
        return claimsJws;
    }

    public boolean validateToken(String token) {
        boolean isValid;
        try {
            Jws<Claims> claimsJws = parseToken(token);
            isValid = !isTokenExpired(claimsJws);

        } catch (Exception e) {
            isValid = false;
        }
        return isValid;
    }

    public boolean isTokenExpired(Jws<Claims> claimsJws) {
        return claimsJws.getBody().getExpiration().before(new Date());
    }


}
