package com.leviosa.api.calls;

import com.leviosa.api.HttpExecutor;
import com.leviosa.api.deserializers.GetDataSourcesOutputDeserializer;
import com.leviosa.api.model.DataSource;

import java.util.List;
import java.util.Objects;

public class GetDataSourcesCall {

    private static final String ENDPOINT = "/v1/data_sources";

    private final String fullEndpoint;

    private final HttpExecutor httpExecutor;

    private final GetDataSourcesOutputDeserializer deserializer;

    public GetDataSourcesCall(String apiDomain, HttpExecutor httpExecutor, GetDataSourcesOutputDeserializer deserializer) {
        this.fullEndpoint = apiDomain + ENDPOINT;
        this.httpExecutor = Objects.requireNonNull(httpExecutor);
        this.deserializer = Objects.requireNonNull(deserializer);
    }

    public List<DataSource> call() {
        String rawResponse = httpExecutor.get(fullEndpoint);
        return deserializer.deserialize(rawResponse);
    }
}
