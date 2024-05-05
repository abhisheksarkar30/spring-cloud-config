package org.edu.abhi.limitsservice.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class ConfigurationLoader {

    @Bean
    @ConfigurationProperties("limits-service.node")
    public Map<String, String> node() {
        return new HashMap<>();
    }
}
