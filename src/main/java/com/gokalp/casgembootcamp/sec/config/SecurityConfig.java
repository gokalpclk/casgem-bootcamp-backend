package com.gokalp.casgembootcamp.sec.config;

import com.gokalp.casgembootcamp.sec.enums.Authority;
import com.gokalp.casgembootcamp.sec.security.JwtUserDetailsConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import java.util.Locale;

/**
 * @author Gokalp on 15.01.2023
 * @project casgem-bootcamp
 */
@EnableWebSecurity
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class SecurityConfig {

    private final JwtUserDetailsConverter jwtUserDetailsConverter;

    public SecurityConfig(JwtUserDetailsConverter jwtUserDetailsConverter) {
        this.jwtUserDetailsConverter = jwtUserDetailsConverter;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .authorizeHttpRequests(authorize -> authorize
                        //  public endpoint everyone can reach without any authority
                        .antMatchers("/api/user/register", "/swagger-ui/**", "/swagger-ui.html",
                                "/swagger-ui/index.html", "/v3/api-docs/**"
                        ).permitAll()

                        //  admin endpoint only admin authority can reach
                        // .antMatchers("/api/user/admin-login")
                        // .hasAuthority(Authority.ADMIN.getAuthority().toUpperCase(Locale.ENGLISH))

                        //  user endpoint only user authority can reach
                        .antMatchers("/api/user/user-login").hasAnyAuthority(
                                Authority.ADMIN.getAuthority().toUpperCase(Locale.ENGLISH),
                                Authority.APPLICANT.getAuthority().toUpperCase(Locale.ENGLISH)
                        )

                        //  editor endpoint only editor authority can reach
                        // .antMatchers("/api/user/editor-login")
                        // .hasAuthority(Authority.EDITOR.getAuthority().toUpperCase(Locale.ENGLISH))

                        //  any authority can reach
                        .antMatchers("/api/user/any-of-request-login").hasAnyAuthority(
                                Authority.ADMIN.getAuthority().toUpperCase(Locale.ENGLISH),
                                Authority.EMPLOYEE.getAuthority().toUpperCase(Locale.ENGLISH),
                                Authority.INSTRUCTOR.getAuthority().toUpperCase(Locale.ENGLISH),
                                Authority.APPLICANT.getAuthority().toUpperCase(Locale.ENGLISH)
                        ).antMatchers("/api/user/me").authenticated())
                .csrf(AbstractHttpConfigurer::disable)
                .oauth2ResourceServer(
                        httpSecurityOAuth2ResourceServerConfigurer -> httpSecurityOAuth2ResourceServerConfigurer
                                .jwt()
                                .jwtAuthenticationConverter(jwtUserDetailsConverter))
                .build();
    }

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}
