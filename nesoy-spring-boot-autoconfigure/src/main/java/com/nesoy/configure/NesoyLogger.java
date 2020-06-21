package com.nesoy.configure;

import java.io.IOException;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class NesoyLogger implements Filter {
    private Logger logger = LoggerFactory.getLogger(NesoyLogger.class);
    private String prefix;

    public NesoyLogger(String prefix) {
        this.prefix = prefix;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        String params = request.getParameterMap()
                .entrySet()
                .stream()
                .map(entry -> entry.getKey() + "=" + String.join(",", entry.getValue()))
                .flatMap(Stream::of)
                .collect(Collectors.joining("&"));

        logger.info(prefix + params);

        chain.doFilter(request, response);
    }
}
