package com.gokalp.casgembootcamp.sec.security;

import com.gokalp.casgembootcamp.sec.enums.Authority;
import com.gokalp.casgembootcamp.usr.entity.UsrUser;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Gokalp on 15.01.2023
 * @project casgem-bootcamp
 */
@Component
public class JwtUserDetailsConverter implements Converter<Jwt, AbstractAuthenticationToken> {
    private final TokenService tokenService;

    public JwtUserDetailsConverter(@Lazy final TokenService tokenService) {
        this.tokenService = tokenService;
    }

    @Override
    public AbstractAuthenticationToken  convert(final Jwt source) {
        final UsrUser user = tokenService.getUser(source);
        return new UsernamePasswordAuthenticationToken(
                user.getEmail(), user.getPassword(), List.of(new SimpleGrantedAuthority(user.getRole().getAuthority())));
    }
}
