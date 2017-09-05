package com.leviosa.apiclient.model;

import com.google.common.base.Preconditions;
import lombok.Getter;

import java.util.List;
import java.util.Objects;

@Getter
public class Player {

    private String name;

    private String position;

    private int nhlTeamId;

    private List<Season> seasons;

    public Player(String name, String position, int nhlTeamId, List<Season> seasons) {
        Preconditions.checkArgument(nhlTeamId > 0);
        this.name = Objects.requireNonNull(name);
        this.position = Objects.requireNonNull(position);
        this.seasons = Objects.requireNonNull(seasons);
        this.nhlTeamId = nhlTeamId;
    }
}
