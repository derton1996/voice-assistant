package org.sibsutis.voice.assistant.service.pattern.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//concrete command
@Service
public class LightSwitcher implements Switcher {

    private final Light light;
    private boolean isOn = false;

    @Autowired
    public LightSwitcher(Light light) {
        this.light = light;
    }

    @Override
    public void toggle() {
        if (isOn) {
            isOn = false;
            light.off();
        } else {
            isOn = true;
            light.on();
        }
    }

}
