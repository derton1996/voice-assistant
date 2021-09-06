package org.sibsutis.voice.assistant.alice;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StateUser {

    private final String value;

    public StateUser(@JsonProperty("value") String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
