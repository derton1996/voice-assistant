package org.sibsutis.voice.assistant.alice;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Interfaces {

    private String screen;

    public Interfaces(@JsonProperty("screen") String screen) {
        this.screen = screen;
    }

    public String getScreen() {
        return screen;
    }

}
