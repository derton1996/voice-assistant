package org.sibsutis.voice.assistant.alice;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AliceRequestBody {

    private final Meta meta;
    private final Session session;
    private final State state;
    private final String version;

    public AliceRequestBody(@JsonProperty("meta") Meta meta,
                            @JsonProperty("session") Session session,
                            @JsonProperty("state") State state,
                            @JsonProperty("version") String version) {
        this.meta = meta;
        this.session = session;
        this.state = state;
        this.version = version;
    }

    public Meta getMeta() {
        return meta;
    }

    public Session getSession() {
        return session;
    }

    public State getState() {
        return state;
    }

    public String getVersion() {
        return version;
    }
}
