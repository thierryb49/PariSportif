package org.tune.parisportif.footballdata;

import java.util.*;
import com.fasterxml.jackson.annotation.*;

public class Competition {
    private long id;
    private Area area;
    private String name;
    private String code;
    private String plan;
    private String lastUpdated;

    @JsonProperty("id")
    public long getID() { return id; }
    @JsonProperty("id")
    public void setID(long value) { this.id = value; }

    @JsonProperty("area")
    public Area getArea() { return area; }
    @JsonProperty("area")
    public void setArea(Area value) { this.area = value; }

    @JsonProperty("name")
    public String getName() { return name; }
    @JsonProperty("name")
    public void setName(String value) { this.name = value; }

    @JsonProperty("code")
    public String getCode() { return code; }
    @JsonProperty("code")
    public void setCode(String value) { this.code = value; }

    @JsonProperty("plan")
    public String getPlan() { return plan; }
    @JsonProperty("plan")
    public void setPlan(String value) { this.plan = value; }

    @JsonProperty("lastUpdated")
    public String getLastUpdated() { return lastUpdated; }
    @JsonProperty("lastUpdated")
    public void setLastUpdated(String value) { this.lastUpdated = value; }
}
