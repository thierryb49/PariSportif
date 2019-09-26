package org.tune.parisportif.footballdata;

import java.util.*;
import java.io.IOException;
import com.fasterxml.jackson.annotation.*;

public enum Status {
    FINISHED, SCHEDULED;

    @JsonValue
    public String toValue() {
        switch (this) {
        case FINISHED: return "FINISHED";
        case SCHEDULED: return "SCHEDULED";
        }
        return null;
    }

    @JsonCreator
    public static Status forValue(String value) throws IOException {
        if (value.equals("FINISHED")) return FINISHED;
        if (value.equals("SCHEDULED")) return SCHEDULED;
        throw new IOException("Cannot deserialize Status");
    }
}
