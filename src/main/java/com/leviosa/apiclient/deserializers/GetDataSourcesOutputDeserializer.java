package com.leviosa.apiclient.deserializers;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.leviosa.apiclient.exceptions.APIResponseParsingException;
import com.leviosa.apiclient.model.DataSource;

import java.util.ArrayList;
import java.util.List;

public class GetDataSourcesOutputDeserializer {

    //TODO: Do better error checking here to produce nicer error messages when the json response doesn't line
    //up with expectations
    public List<DataSource> deserialize(String data) {
        try {
            return deserializeDataSources(data);
        } catch (Exception e) {
            throw new APIResponseParsingException("Unable to parse the apiclient response:\n" + data + "\n", e);
        }
    }

    private List<DataSource> deserializeDataSources(String data) {
        JsonObject json = new JsonParser().parse(data).getAsJsonObject();
        JsonArray dataArray = json.getAsJsonArray("data");
        List<DataSource> dataSources = new ArrayList<>(dataArray.size());
        for(int i = 0; i < dataArray.size(); i++) {
            DataSource dataSource = extractDataSource(dataArray.get(i).getAsJsonObject());
            dataSources.add(dataSource);
        }
        return dataSources;
    }

    private DataSource extractDataSource(JsonObject dataSrc) {
        JsonObject dataSrcAttrs = dataSrc.getAsJsonObject("attributes");
        int id = dataSrc.get("id").getAsInt();
        String name = dataSrcAttrs.get("name").getAsString();
        int playerId = dataSrcAttrs.get("player-id").getAsInt();
        String playerLookup = dataSrcAttrs.get("player-lookup").getAsString();
        return new DataSource(id, playerId, name, playerLookup);
    }
}
