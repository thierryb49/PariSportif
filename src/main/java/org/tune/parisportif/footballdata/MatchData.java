package org.tune.parisportif.footballdata;

import java.util.*;
import com.fasterxml.jackson.annotation.*;

public class MatchData {
    private long count;
    private Filters filters;
    private Competition competition;
    private List<Match> matches;

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

    @JsonProperty("matches")
    public List<Match> getMatches() { return matches; }
    @JsonProperty("matches")
    public void setMatches(List<Match> value) { this.matches = value; }
}
