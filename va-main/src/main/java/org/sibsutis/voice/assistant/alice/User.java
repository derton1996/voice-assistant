package org.sibsutis.voice.assistant.alice;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User {

    private final String id;
    private final String accessToken;

    public User(@JsonProperty("user_id") String id,
                @JsonProperty("access_token") String accessToken) {
        this.id = id;
        this.accessToken = accessToken;
    }

    public String getId() {
        return id;
    }

    public String getAccessToken() {
        return accessToken;
    }
}
