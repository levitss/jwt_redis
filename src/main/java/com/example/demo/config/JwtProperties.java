package com.example.demo.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
@Getter
@Setter
@ConfigurationProperties("jwt")
@Component
public class JwtProperties {
    private String issuer;
    private String secret_key;
}
