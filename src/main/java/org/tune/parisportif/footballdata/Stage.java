package org.tune.parisportif.footballdata;

import java.util.*;
import java.io.IOException;
import com.fasterxml.jackson.annotation.*;

public enum Stage {
    REGULAR_SEASON;

    @JsonValue
    public String toValue() {
        switch (this) {
        case REGULAR_SEASON: return "REGULAR_SEASON";
        }
        return null;
    }

    @JsonCreator
    public static Stage forValue(String value) throws IOException {
        if (value.equals("REGULAR_SEASON")) return REGULAR_SEASON;
        throw new IOException("Cannot deserialize Stage");
    }
}
