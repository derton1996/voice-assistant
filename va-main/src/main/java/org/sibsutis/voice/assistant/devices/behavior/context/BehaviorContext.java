package org.sibsutis.voice.assistant.devices.behavior.context;

import java.util.HashMap;

public class BehaviorContext {

    private HashMap<String, Object> parameters = new HashMap<>();

    public void put(String key, Object value) {
        parameters.put(key, value);
    }

    public void get(String key) {
        parameters.get(key);
    }

}
