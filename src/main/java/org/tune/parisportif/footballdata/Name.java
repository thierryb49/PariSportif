package org.tune.parisportif.footballdata;

import java.util.*;
import java.io.IOException;
import com.fasterxml.jackson.annotation.*;

public enum Name {
    FRANCE, MONACO;

    @JsonValue
    public String toValue() {
        switch (this) {
        case FRANCE: return "France";
        case MONACO: return "Monaco";
        }
        return null;
    }

    @JsonCreator
    public static Name forValue(String value) throws IOException {
        if (value.equals("France")) return FRANCE;
        if (value.equals("Monaco")) return MONACO;
        throw new IOException("Cannot deserialize Name");
    }
}
