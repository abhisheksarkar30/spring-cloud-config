package org.edu.abhi.limitsservice.controller;

import org.edu.abhi.limitsservice.config.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope //only required for @Value beans
public class LimitsController {

    @Autowired
    private Configuration configure;

    @Autowired
    private Environment env;

    @Value("${limits-service.min}") //This annotation won't work with complex structure for dynamic refresh
    private int min;

    @GetMapping("/limitsByConfig")
    public Configuration getLimitsByConfig() {
        return configure;
    }

    @GetMapping("/limitsByEnv")
    public String getLimitsByEnv() {
        return env.getProperty("limits-service.min");
    }

    @GetMapping("/limitsByValue")
    public int getLimitsByValue() {
        return min;
    }

//    @Value("${check.absent}")
    private String absent = "isOk";

    @GetMapping("/checkAbsent")
    public String getCheckAbsent() {
        return absent;
    }

}
