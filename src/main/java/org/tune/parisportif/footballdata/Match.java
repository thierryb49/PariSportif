package org.tune.parisportif.footballdata;

import java.util.*;
import com.fasterxml.jackson.annotation.*;

public class Match {
    private long id;
    private Season season;
    private String utcDate;
    private Status status;
    private long matchday;
    private Stage stage;
    private Group group;
    private String lastUpdated;
    private Score score;
    private Area homeTeam;
    private Area awayTeam;
    private List<Referee> referees;

    @JsonProperty("id")
    public long getID() { return id; }
    @JsonProperty("id")
    public void setID(long value) { this.id = value; }

    @JsonProperty("season")
    public Season getSeason() { return season; }
    @JsonProperty("season")
    public void setSeason(Season value) { this.season = value; }

    @JsonProperty("utcDate")
    public String getUTCDate() { return utcDate; }
    @JsonProperty("utcDate")
    public void setUTCDate(String value) { this.utcDate = value; }

    @JsonProperty("status")
    public Status getStatus() { return status; }
    @JsonProperty("status")
    public void setStatus(Status value) { this.status = value; }

    @JsonProperty("matchday")
    public long getMatchday() { return matchday; }
    @JsonProperty("matchday")
    public void setMatchday(long value) { this.matchday = value; }

    @JsonProperty("stage")
    public Stage getStage() { return stage; }
    @JsonProperty("stage")
    public void setStage(Stage value) { this.stage = value; }

    @JsonProperty("group")
    public Group getGroup() { return group; }
    @JsonProperty("group")
    public void setGroup(Group value) { this.group = value; }

    @JsonProperty("lastUpdated")
    public String getLastUpdated() { return lastUpdated; }
    @JsonProperty("lastUpdated")
    public void setLastUpdated(String value) { this.lastUpdated = value; }

    @JsonProperty("score")
    public Score getScore() { return score; }
    @JsonProperty("score")
    public void setScore(Score value) { this.score = value; }

    @JsonProperty("homeTeam")
    public Area getHomeTeam() { return homeTeam; }
    @JsonProperty("homeTeam")
    public void setHomeTeam(Area value) { this.homeTeam = value; }

    @JsonProperty("awayTeam")
    public Area getAwayTeam() { return awayTeam; }
    @JsonProperty("awayTeam")
    public void setAwayTeam(Area value) { this.awayTeam = value; }

    @JsonProperty("referees")
    public List<Referee> getReferees() { return referees; }
    @JsonProperty("referees")
    public void setReferees(List<Referee> value) { this.referees = value; }
}
