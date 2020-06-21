package com.nesoy.configure;

import javax.servlet.Filter;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@AutoConfigureAfter(WebMvcAutoConfiguration.class)
@ConditionalOnProperty(name = "nesoy.log")
@EnableConfigurationProperties(NesoyProperties.class)
public class NesoyAutoConfiguration {

    private final NesoyProperties nesoyProperties;

    public NesoyAutoConfiguration(NesoyProperties nesoyProperties) {
        this.nesoyProperties = nesoyProperties;
    }

    @Bean
    public Filter customUriLoggingFilter() {
        return new NesoyLogger(nesoyProperties.getLog());
    }
}