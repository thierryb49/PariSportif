package org.tune.parisportif.footballdata;

import java.util.*;
import com.fasterxml.jackson.annotation.*;

public class TeamData {
    private long count;
    private Filters filters;
    private Competition competition;
    private Season season;
    private List<Team> teams;

    @JsonProperty("count")
    public long getCount() { return count; }
    @JsonProperty("count")
    public void setCount(long value) { this.count = value; }

    @JsonProperty("filters")
    public Filters getFilters() { return filters; }
    @JsonProperty("filters")
    public void setFilters(Filters value) { this.filters = value; }

    @JsonProperty("competition")
    public Competition getCompetition() { return competition; }
    @JsonProperty("competition")
    public void setCompetition(Competition value) { this.competition = value; }

    @JsonProperty("season")
    public Season getSeason() { return season; }
    @JsonProperty("season")
    public void setSeason(Season value) { this.season = value; }

    @JsonProperty("teams")
    public List<Team> getTeams() { return teams; }
    @JsonProperty("teams")
    public void setTeams(List<Team> value) { this.teams = value; }
}
