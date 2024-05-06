package org.edu.abhi.limitsservice.config;

import jakarta.annotation.PostConstruct;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Map;

@Getter
//Below annotation is required (for dynamic refresh) even if a separate config bean loader used by same annotation
@ConfigurationProperties(prefix = "limits-service")
public class Configuration {

    @Setter
    private int min;
    @Setter
    private int max;
    @Setter
    private String simple;
    @Setter
    private String checkByHyphen;
    @Setter
    private String checkByDot;

    @Autowired
    @Qualifier("node")
    private Map<String, String> node;
    private String localNode;
    @Setter
    private Map<String, String> check;
    @Setter
    private Test test = new Test();

    @Setter
    private Map<String, String> input; // nothing else will work for mixed data types

    @Getter @Setter
    public static class Test {
        private Map<String, String> by;
    }

    @PostConstruct //will run for every hit to config refresh endpoint
    private void setConfig() {
        //@ConfigurationProperties dynamically refreshes each node/variable directly from config files
        //any app bean (like singleton) which keeps old config cached needs to be manually refreshed
        //either by re-registering a new bean instead to the bean context container or setting new value inside 
        localNode = node.get("second");
        System.out.println("executed");
    }
}
