package com.leviosa.api.model;

import com.google.common.base.Preconditions;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
public class Team {
    private String name;

    private String code;

    private int teamId;

    private List<Player> players = new ArrayList<>();

    public Team(String name, String code, int teamId, List<Player> players) {
        Preconditions.checkArgument(teamId > 0);
        this.name = Objects.requireNonNull(name);
        this.code = Objects.requireNonNull(code);
        this.teamId = teamId;
        this.players = Objects.requireNonNull(players);
    }
}
