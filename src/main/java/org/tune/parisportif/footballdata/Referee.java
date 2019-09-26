package org.tune.parisportif.footballdata;

import java.util.*;
import com.fasterxml.jackson.annotation.*;

public class Referee {
    private long id;
    private String name;
    private Object nationality;

    @JsonProperty("id")
    public long getID() { return id; }
    @JsonProperty("id")
    public void setID(long value) { this.id = value; }

    @JsonProperty("name")
    public String getName() { return name; }
    @JsonProperty("name")
    public void setName(String value) { this.name = value; }

    @JsonProperty("nationality")
    public Object getNationality() { return nationality; }
    @JsonProperty("nationality")
    public void setNationality(Object value) { this.nationality = value; }
}
