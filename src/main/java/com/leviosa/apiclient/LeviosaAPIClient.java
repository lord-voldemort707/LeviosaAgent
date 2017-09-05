package com.leviosa.apiclient;

import com.leviosa.apiclient.calls.GetDataSourcesCall;
import com.leviosa.apiclient.deserializers.GetDataSourcesOutputDeserializer;
import com.leviosa.apiclient.model.DataSource;
import org.apache.http.impl.client.HttpClients;

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
