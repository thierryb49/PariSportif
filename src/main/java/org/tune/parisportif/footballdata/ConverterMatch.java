// To use this code, add the following Maven dependency to your project:
//
//     com.fasterxml.jackson.core : jackson-databind : 2.9.0
//
// Import this package:
//
//     import org.tune.parisportif.footballdata.Converter;
//
// Then you can deserialize a JSON string with
//
//     MatchData data = Converter.fromJsonString(jsonString);

package org.tune.parisportif.footballdata;

import java.util.*;
import java.io.IOException;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.core.JsonProcessingException;

public class ConverterMatch {
    // Serialize/deserialize helpers

    public static MatchData fromJsonString(String json) throws IOException {
        return getObjectReader().readValue(json);
    }

    public static String toJsonString(MatchData obj) throws JsonProcessingException {
        return getObjectWriter().writeValueAsString(obj);
    }

    private static ObjectReader reader;
    private static ObjectWriter writer;

    private static void instantiateMapper() {
        ObjectMapper mapper = new ObjectMapper();
        reader = mapper.reader(MatchData.class);
        writer = mapper.writerFor(MatchData.class);
    }

    private static ObjectReader getObjectReader() {
        if (reader == null) instantiateMapper();
        return reader;
    }

    private static ObjectWriter getObjectWriter() {
        if (writer == null) instantiateMapper();
        return writer;
    }
}
