package org.tune.parisportif.footballdata;

import java.util.*;
import com.fasterxml.jackson.annotation.*;

public class Filters {
    private String matchday;

    @JsonProperty("matchday")
    public String getMatchday() { return matchday; }
    @JsonProperty("matchday")
    public void setMatchday(String value) { this.matchday = value; }
}
