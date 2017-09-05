package com.leviosa.apiclient.calls;

import com.leviosa.apiclient.HttpExecutor;
import com.leviosa.apiclient.deserializers.GetDataSourcesOutputDeserializer;
import com.leviosa.apiclient.model.DataSource;

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
