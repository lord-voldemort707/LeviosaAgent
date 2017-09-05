package com.leviosa.api.model;

import com.google.common.base.Preconditions;
import lombok.Getter;
import lombok.ToString;

import java.util.Objects;

@Getter
@ToString
public class DataSource {

    private int id;

    private String name;

    private String playerLookup;

    private int playerId;

    public DataSource(int id, int playerId, String name, String playerLookup) {
        Preconditions.checkArgument(playerId > 0);
        this.name = Objects.requireNonNull(name);
        this.playerLookup = Objects.requireNonNull(playerLookup);
        this.playerId = playerId;
    }
}
