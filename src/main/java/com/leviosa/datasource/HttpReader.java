package com.leviosa.datasource;

import com.leviosa.apiclient.HttpExecutor;

import java.util.Objects;

public class HttpReader implements DataSourceReader {

    private HttpExecutor httpExecutor;

    private String endpoint;

    public HttpReader(HttpExecutor httpExecutor, String endpoint) {
        this.httpExecutor = Objects.requireNonNull(httpExecutor);
        this.endpoint = Objects.requireNonNull(endpoint);
    }

    @Override
    public String read() {
        return httpExecutor.get(endpoint);
    }
}
