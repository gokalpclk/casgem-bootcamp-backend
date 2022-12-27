package com.gokalp.casgembootcamp.sec.security;

import com.gokalp.casgembootcamp.sec.enums.EnumJwtConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Gokalp on 27.12.2022
 * @project casgem-bootcamp
 */
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private JwtUserDetailsService jwtUserDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = getToken(request);
        if (StringUtils.hasText(token)) {
            boolean isValid = jwtTokenProvider.validateToken(token);
            if (isValid) {
                Long userId = jwtTokenProvider.findUserIdByToken(token);
                UserDetails userDetails = jwtUserDetailsService.loadUserById(userId);
                if (userDetails != null) {
                    UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                    authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                    SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                }
            }
        }
        filterChain.doFilter(request, response);
    }

    private String getToken(HttpServletRequest request) {
        String fullToken = request.getHeader("Authorization");
        String token = null;
        if (StringUtils.hasText(fullToken)) {
            String bearer = EnumJwtConstant.BEARER.getConstant();
            if (fullToken.startsWith(bearer)) {
                token = fullToken.substring(bearer.length());
            }
        }
        return token;
    }
}
