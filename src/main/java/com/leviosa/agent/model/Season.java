package com.leviosa.agent.model;

import com.google.common.base.Preconditions;
import lombok.Builder;
import lombok.Getter;

import java.util.Objects;

@Getter
public class Season {

    private String season;

    private String team;

    private String league;

    private int gamesPlayed;

    private int goals;

    private int assists;

    private int points;

    private int pim;

    private int shots;

    private int playerId;

    public Season(String season, String team, String league, int gamesPlayed, int goals, int assists, int points, int pim, int shots, int playerId) {
        Preconditions.checkArgument(playerId > 0);
        this.season = Objects.requireNonNull(season);
        this.team = Objects.requireNonNull(team);
        this.league = Objects.requireNonNull(league);
        this.gamesPlayed = gamesPlayed;
        this.goals = goals;
        this.assists = assists;
        this.points = points;
        this.pim = pim;
        this.shots = shots;
        this.playerId = playerId;
    }
}

