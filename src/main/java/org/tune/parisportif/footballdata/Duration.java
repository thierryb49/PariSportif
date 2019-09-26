package org.tune.parisportif.footballdata;

import java.util.*;
import java.io.IOException;
import com.fasterxml.jackson.annotation.*;

public enum Duration {
    REGULAR;

    @JsonValue
    public String toValue() {
        switch (this) {
        case REGULAR: return "REGULAR";
        }
        return null;
    }

    @JsonCreator
    public static Duration forValue(String value) throws IOException {
        if (value.equals("REGULAR")) return REGULAR;
        throw new IOException("Cannot deserialize Duration");
    }
}
