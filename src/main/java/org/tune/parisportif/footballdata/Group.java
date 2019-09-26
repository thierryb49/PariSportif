package org.tune.parisportif.footballdata;

import java.util.*;
import java.io.IOException;
import com.fasterxml.jackson.annotation.*;

public enum Group {
    REGULAR_SEASON;

    @JsonValue
    public String toValue() {
        switch (this) {
        case REGULAR_SEASON: return "Regular Season";
        }
        return null;
    }

    @JsonCreator
    public static Group forValue(String value) throws IOException {
        if (value.equals("Regular Season")) return REGULAR_SEASON;
        throw new IOException("Cannot deserialize Group");
    }
}
