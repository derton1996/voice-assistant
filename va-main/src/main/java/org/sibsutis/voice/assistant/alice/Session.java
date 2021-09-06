package org.sibsutis.voice.assistant.alice;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Session {

    private final Integer messageId;
    private final String sessionId;
    private final String skillId;
    private final User user;
    private final Application application;
    private final boolean isNew;

    public Session(@JsonProperty("message_id") Integer messageId,
                   @JsonProperty("session_id") String sessionId,
                   @JsonProperty("skill_id") String skillId,
                   @JsonProperty("user") User user,
                   @JsonProperty("application") Application application,
                   @JsonProperty("new") boolean isNew) {
        this.messageId = messageId;
        this.sessionId = sessionId;
        this.skillId = skillId;
        this.user = user;
        this.application = application;
        this.isNew = isNew;
    }

    public Integer getMessageId() {
        return messageId;
    }

    public String getSessionId() {
        return sessionId;
    }

    public String getSkillId() {
        return skillId;
    }

    public User getUser() {
        return user;
    }

    public Application getApplication() {
        return application;
    }

    public boolean getNew() {
        return isNew;
    }
}
