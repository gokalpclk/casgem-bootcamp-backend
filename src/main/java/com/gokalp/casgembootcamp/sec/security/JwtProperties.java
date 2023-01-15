package com.gokalp.casgembootcamp.sec.security;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;

/**
 * @author Gokalp on 15.01.2023
 * @project casgem-bootcamp
 */
@Getter
@Setter
@Configuration
@ConfigurationProperties("jwt")
public class JwtProperties {
    @Value("${jwt.algorithm}")
    private String algorithm;
    @Value("${jwt.app.key}")
    private String secretKey;
    @Value("${jwt.issuer}")
    private String issuer;
    @Value("${jwt.expire.time}")
    private Duration expiration;
}
