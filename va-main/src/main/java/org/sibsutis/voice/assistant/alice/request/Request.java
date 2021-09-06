package org.sibsutis.voice.assistant.alice.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Request {

    private final Type type;
    private final String command;

    public Request(@JsonProperty("type") String type,
                  @JsonProperty("command") String command) {
        this.type = Type.getByName(type);
        this.command = command;
    }

    public Type getType() {
        return type;
    }

    public String getCommand() {
        return command;
    }
}
