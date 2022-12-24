package com.gokalp.casgembootcamp.sec.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

/**
 * @author Gokalp on 25.12.2022
 * @project casgem-bootcamp
 */
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
@Configuration
public class SecurityConfiguration {

//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http
//                .authorizeHttpRequests((authz) -> authz
//                        .anyRequest().authenticated()
//                )
//                .httpBasic(withDefaults());
//        return http.build();
//    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.httpBasic();

        http
                .authorizeHttpRequests((authz) -> authz
                        .anyRequest().authenticated()
                )
                .httpBasic(withDefaults());
        return http.build();
    }



//    Ignore any root
//    @Bean
//    public WebSecurityCustomizer webSecurityCustomizer() {
//        return (web) -> web.ignoring().anyRequest();
//    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> {
            web.ignoring().antMatchers("/api/v1/*");
        };
    }

}
