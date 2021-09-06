package org.sibsutis.voice.assistant.alice;

import com.fasterxml.jackson.annotation.JsonProperty;

public class State {

    private final StateSession stateSession;
    private final StateUser stateUser;
    private final StateSession stateApplication;

    public State(@JsonProperty("session") StateSession stateSession,
                 @JsonProperty("user") StateUser stateUser,
                 @JsonProperty("application") StateSession stateApplication) {
        this.stateSession = stateSession;
        this.stateUser = stateUser;
        this.stateApplication = stateApplication;
    }

    public StateSession getStateSession() {
        return stateSession;
    }

    public StateUser getStateUser() {
        return stateUser;
    }

    public StateSession getStateApplication() {
        return stateApplication;
    }
}
