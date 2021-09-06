package org.sibsutis.voice.assistant.alice;


import com.fasterxml.jackson.annotation.JsonProperty;

public class Meta {

    private String locale;
    private String timezone;
    private Interfaces interfaces;

    public Meta(@JsonProperty("locale") String locale,
                @JsonProperty("timezone") String timezone,
                @JsonProperty("interfaces") Interfaces interfaces) {
        this.locale = locale;
        this.timezone = timezone;
        this.interfaces = interfaces;
    }

    public String getLocale() {
        return locale;
    }

    public String getTimezone() {
        return timezone;
    }

    public Interfaces getInterfaces() {
        return interfaces;
    }
}
