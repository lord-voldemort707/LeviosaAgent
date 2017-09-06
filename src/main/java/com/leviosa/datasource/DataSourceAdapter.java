package com.leviosa.datasource;

import com.leviosa.apiclient.HttpExecutor;
import com.leviosa.apiclient.model.DataSource;
import com.leviosa.apiclient.model.Player;
import org.apache.http.impl.client.HttpClients;

import java.util.Objects;

public class DataSourceAdapter {

    private static final HttpExecutor httpExecutor = new HttpExecutor(HttpClients.createDefault());

    private DataSourceReader dataSourceReader;

    private DataSourceParser dataSourceParser;

    private String dataSourceName;

    public DataSourceAdapter(DataSourceReader dataSourceReader, DataSourceParser parser, String dataSourceName) {
        this.dataSourceReader = Objects.requireNonNull(dataSourceReader);
        this.dataSourceParser = Objects.requireNonNull(parser);
        this.dataSourceName = Objects.requireNonNull(dataSourceName);
    }

    public Player getPlayer() {
        return dataSourceParser.parse(dataSourceReader.read());
    }

    public static DataSourceAdapter fromDataSource(DataSource dataSource) {
        switch (dataSource.getName()) {
            case "EP": {
                DataSourceReader reader = new HttpReader(httpExecutor, dataSource.getPlayerLookup());
                DataSourceParser parser = new EliteProspectsParser();
                return new DataSourceAdapter(reader, parser, "EliteProspects");
            }
            default: {
                throw new IllegalStateException("Unknown Datasource " + dataSource.getName());
            }
        }
    }
}
