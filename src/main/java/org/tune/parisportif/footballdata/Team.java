package org.tune.parisportif.footballdata;

import java.util.*;
import com.fasterxml.jackson.annotation.*;

public class Team {
    private long id;
    private Area area;
    private String name;
    private String shortName;
    private String tla;
    private String crestURL;
    private String address;
    private String phone;
    private String website;
    private String email;
    private long founded;
    private String clubColors;
    private String venue;
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

    @JsonProperty("shortName")
    public String getShortName() { return shortName; }
    @JsonProperty("shortName")
    public void setShortName(String value) { this.shortName = value; }

    @JsonProperty("tla")
    public String getTLA() { return tla; }
    @JsonProperty("tla")
    public void setTLA(String value) { this.tla = value; }

    @JsonProperty("crestUrl")
    public String getCrestURL() { return crestURL; }
    @JsonProperty("crestUrl")
    public void setCrestURL(String value) { this.crestURL = value; }

    @JsonProperty("address")
    public String getAddress() { return address; }
    @JsonProperty("address")
    public void setAddress(String value) { this.address = value; }

    @JsonProperty("phone")
    public String getPhone() { return phone; }
    @JsonProperty("phone")
    public void setPhone(String value) { this.phone = value; }

    @JsonProperty("website")
    public String getWebsite() { return website; }
    @JsonProperty("website")
    public void setWebsite(String value) { this.website = value; }

    @JsonProperty("email")
    public String getEmail() { return email; }
    @JsonProperty("email")
    public void setEmail(String value) { this.email = value; }

    @JsonProperty("founded")
    public long getFounded() { return founded; }
    @JsonProperty("founded")
    public void setFounded(long value) { this.founded = value; }

    @JsonProperty("clubColors")
    public String getClubColors() { return clubColors; }
    @JsonProperty("clubColors")
    public void setClubColors(String value) { this.clubColors = value; }

    @JsonProperty("venue")
    public String getVenue() { return venue; }
    @JsonProperty("venue")
    public void setVenue(String value) { this.venue = value; }

    @JsonProperty("lastUpdated")
    public String getLastUpdated() { return lastUpdated; }
    @JsonProperty("lastUpdated")
    public void setLastUpdated(String value) { this.lastUpdated = value; }
}
