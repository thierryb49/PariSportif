package org.tune.parisportif.footballdata;

import java.util.*;
import com.fasterxml.jackson.annotation.*;

public class Score {
    private String winner;
    private Duration duration;
    private ExtraTime fullTime;
    private ExtraTime halfTime;
    private ExtraTime extraTime;
    private ExtraTime penalties;

    @JsonProperty("winner")
    public String getWinner() { return winner; }
    @JsonProperty("winner")
    public void setWinner(String value) { this.winner = value; }

    @JsonProperty("duration")
    public Duration getDuration() { return duration; }
    @JsonProperty("duration")
    public void setDuration(Duration value) { this.duration = value; }

    @JsonProperty("fullTime")
    public ExtraTime getFullTime() { return fullTime; }
    @JsonProperty("fullTime")
    public void setFullTime(ExtraTime value) { this.fullTime = value; }

    @JsonProperty("halfTime")
    public ExtraTime getHalfTime() { return halfTime; }
    @JsonProperty("halfTime")
    public void setHalfTime(ExtraTime value) { this.halfTime = value; }

    @JsonProperty("extraTime")
    public ExtraTime getExtraTime() { return extraTime; }
    @JsonProperty("extraTime")
    public void setExtraTime(ExtraTime value) { this.extraTime = value; }

    @JsonProperty("penalties")
    public ExtraTime getPenalties() { return penalties; }
    @JsonProperty("penalties")
    public void setPenalties(ExtraTime value) { this.penalties = value; }
}
