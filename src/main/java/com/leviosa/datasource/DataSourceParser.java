package com.leviosa.datasource;

import com.leviosa.apiclient.model.Player;

import java.util.List;

public interface DataSourceParser {

    Player parse(String data);
}
