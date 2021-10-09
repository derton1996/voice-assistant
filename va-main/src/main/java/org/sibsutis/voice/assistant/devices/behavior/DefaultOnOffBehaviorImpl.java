package org.sibsutis.voice.assistant.devices.behavior;

import org.sibsutis.voice.assistant.devices.behavior.context.BehaviorContext;
import org.springframework.stereotype.Service;

@Service
public class DefaultOnOffBehaviorImpl implements OnOffBehavior {

    @Override
    public void toggle(BehaviorContext behaviorContext) {
        System.out.println("toggle!");
    }

}
