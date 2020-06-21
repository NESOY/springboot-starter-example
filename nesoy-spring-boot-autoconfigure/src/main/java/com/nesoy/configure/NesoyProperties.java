package com.nesoy.configure;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "nesoy")
public class NesoyProperties {

    private String log;

    public String getLog() {
        return log;
    }

    public void setLog(String log) {
        this.log = log;
    }
}
