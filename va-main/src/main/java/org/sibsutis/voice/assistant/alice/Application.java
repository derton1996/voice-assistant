package org.sibsutis.voice.assistant.alice;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Application {

    private final String id;

    public Application(@JsonProperty("application_id") String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
