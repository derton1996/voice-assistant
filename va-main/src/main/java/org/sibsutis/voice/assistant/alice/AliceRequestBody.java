package org.sibsutis.voice.assistant.alice;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.sibsutis.voice.assistant.alice.request.Request;

public class AliceRequestBody {

    private final Meta meta;
    private final Session session;
    private final State state;
    private final String version;
    private final Request request;

    public AliceRequestBody(@JsonProperty("meta") Meta meta,
                            @JsonProperty("session") Session session,
                            @JsonProperty("state") State state,
                            @JsonProperty("version") String version,
                            @JsonProperty("request") Request request) {
        this.meta = meta;
        this.session = session;
        this.state = state;
        this.version = version;
        this.request = request;
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

    public Request getRequest() {
        return request;
    }
}
