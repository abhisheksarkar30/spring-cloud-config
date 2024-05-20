package org.edu.abhi.limitsservice.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class AppConfigurationLoader {

    @Bean
    //Below annotation works perfectly with complex structure for dynamic refresh & specific target config loading
    @ConfigurationProperties("limits-service.node")
    public Map<String, String> node() {
        return new HashMap<>();
    }
}
