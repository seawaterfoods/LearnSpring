package com.joe.retailforest.method;

import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;

import java.net.URI;

public class HttpGetWithEntity extends HttpEntityEnclosingRequestBase {

    private final static String METHOD_NAME = "GET";

    @Override
    public String getMethod() {
        return METHOD_NAME;
    }

    public HttpGetWithEntity() {
    }

    public HttpGetWithEntity(final URI uri) {
        this.setURI(uri);
    }

    HttpGetWithEntity(final String uri) {
        this.setURI(URI.create(uri));
    }
}