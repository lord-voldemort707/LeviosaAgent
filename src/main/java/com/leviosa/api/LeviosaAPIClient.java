package com.leviosa.api;

import com.leviosa.api.calls.GetDataSourcesCall;
import com.leviosa.api.deserializers.GetDataSourcesOutputDeserializer;
import com.leviosa.api.model.DataSource;
import org.apache.http.impl.client.HttpClients;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LeviosaAPIClient {

    private GetDataSourcesCall getDataSourcesCall;

    public  LeviosaAPIClient(GetDataSourcesCall getDataSourcesCall) {
        this.getDataSourcesCall = Objects.requireNonNull(getDataSourcesCall);
    }

    public List<DataSource> getDataSourcesForPlayers() {
        return getDataSourcesCall.call();
    }

    public static LeviosaAPIClient create(String apiDomain) {
        HttpExecutor executor = new HttpExecutor(HttpClients.createDefault());
        GetDataSourcesCall getDataSourcesCall = new GetDataSourcesCall(apiDomain, executor, new GetDataSourcesOutputDeserializer());
        return new LeviosaAPIClient(getDataSourcesCall);
    }
}
