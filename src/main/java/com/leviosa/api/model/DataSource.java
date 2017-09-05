package com.leviosa.api.model;

import com.google.common.base.Preconditions;
import lombok.Getter;

import java.util.Objects;

@Getter
public class DataSource {

    private String name;

    private String playerLookup;

    private int playerId;

    public DataSource(String name, String playerLookup, int playerId) {
        Preconditions.checkArgument(playerId > 0);
        this.name = Objects.requireNonNull(name);
        this.playerLookup = Objects.requireNonNull(playerLookup);
        this.playerId = playerId;
    }
}
