package org.sibsutis.voice.assistant.alice;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StateApplication {

    private final String value;

    public StateApplication(@JsonProperty("value") String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
