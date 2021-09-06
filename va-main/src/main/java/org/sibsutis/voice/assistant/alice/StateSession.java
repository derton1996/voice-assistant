package org.sibsutis.voice.assistant.alice;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StateSession {

    private final String value;

    public StateSession(@JsonProperty("value") String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
