package org.tune.parisportif.footballdata;

import java.util.*;
import com.fasterxml.jackson.annotation.*;

public class Season {
    private long id;
    private String startDate;
    private String endDate;
    private long currentMatchday;
    private Object winner;

    @JsonProperty("id")
    public long getID() { return id; }
    @JsonProperty("id")
    public void setID(long value) { this.id = value; }

    @JsonProperty("startDate")
    public String getStartDate() { return startDate; }
    @JsonProperty("startDate")
    public void setStartDate(String value) { this.startDate = value; }

    @JsonProperty("endDate")
    public String getEndDate() { return endDate; }
    @JsonProperty("endDate")
    public void setEndDate(String value) { this.endDate = value; }

    @JsonProperty("currentMatchday")
    public long getCurrentMatchday() { return currentMatchday; }
    @JsonProperty("currentMatchday")
    public void setCurrentMatchday(long value) { this.currentMatchday = value; }
    
    @JsonProperty("winner")
    public Object getWinner() { return winner; }
    @JsonProperty("winner")
    public void setWinner(Object value) { this.winner = value; }
}
