package org.tune.parisportif.footballdata;

import java.util.*;
import com.fasterxml.jackson.annotation.*;

public class ExtraTime {
    private Long homeTeam;
    private Long awayTeam;

    @JsonProperty("homeTeam")
    public Long getHomeTeam() { return homeTeam; }
    @JsonProperty("homeTeam")
    public void setHomeTeam(Long value) { this.homeTeam = value; }

    @JsonProperty("awayTeam")
    public Long getAwayTeam() { return awayTeam; }
    @JsonProperty("awayTeam")
    public void setAwayTeam(Long value) { this.awayTeam = value; }
}
