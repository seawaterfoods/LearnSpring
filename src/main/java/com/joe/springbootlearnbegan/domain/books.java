package com.joe.springbootlearnbegan.domain;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix="book")
public class books {

    private String name;

    private String author;

    private String isbn;

    private String description;

    public books() {
    }
}
