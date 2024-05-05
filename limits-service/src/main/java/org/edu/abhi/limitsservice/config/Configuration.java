package org.edu.abhi.limitsservice.config;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Map;

@ConfigurationProperties(prefix = "limits-service")
public class Configuration {

    private int min;
    private int max;
    private String simple;
    private String checkByHyphen;
    private String checkByDot;

    @Autowired
    @Qualifier("node")
    private Map<String, String> node;
    private String localNode;

    private Map<String, String> check;

    private Test test = new Test();

    private Map<String, String> input; // nothing else will work for mixed types

    public Map<String, String> getInput() {
        return input;
    }

    public void setInput(Map<String, String> input) {
        this.input = input;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public String getSimple() {
        return simple;
    }

    public void setSimple(String simple) {
        this.simple = simple;
    }

    public String getCheckByHyphen() {
        return checkByHyphen;
    }

    public void setCheckByHyphen(String checkByHyphen) {
        this.checkByHyphen = checkByHyphen;
    }

    public String getCheckByDot() {
        return checkByDot;
    }

    public void setCheckByDot(String checkByDot) {
        this.checkByDot = checkByDot;
    }

    public Map<String, String> getCheck() {
        return check;
    }

    public void setCheck(Map<String, String> check) {
        this.check = check;
    }

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }

    public static class Test {

        private Map<String, String> by;

        public Map<String, String> getBy() {
            return by;
        }

        public void setBy(Map<String, String> by) {
            this.by = by;
        }
    }

    public Map<String, String> getNode() {
        return node;
    }

    public String getLocalNode() {
        return localNode;
    }

    @PostConstruct
    private void setConfig() {
        localNode = node.get("second");
        System.out.println("executed");
    }
}
