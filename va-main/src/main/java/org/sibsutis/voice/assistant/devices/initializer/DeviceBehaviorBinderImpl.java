package org.sibsutis.voice.assistant.devices.initializer;

import org.sibsutis.voice.assistant.common.DeviceEnum;
import org.sibsutis.voice.assistant.common.PropertyEnum;
import org.sibsutis.voice.assistant.devices.BrailleBoardBehavior;
import org.sibsutis.voice.assistant.devices.DeviceBehavior;
import org.sibsutis.voice.assistant.devices.behavior.context.BehaviorContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.EnumMap;
import java.util.Map;

@Service
public class DeviceBehaviorBinderImpl<T extends DeviceBehavior> implements DeviceBehaviorBinder {

    private final Map<DeviceEnum, T> deviceBehaviorBinder = new EnumMap<>(DeviceEnum.class);

    private final BrailleBoardBehavior brailleBoardBehavior;

    @Autowired
    public DeviceBehaviorBinderImpl(BrailleBoardBehavior brailleBoardBehavior) {
        this.brailleBoardBehavior = brailleBoardBehavior;
    }

    @PostConstruct
    public void init() {
        deviceBehaviorBinder.put(DeviceEnum.BRAILLE_BOARD, (T) brailleBoardBehavior);
    }


    public void execute(DeviceEnum device, PropertyEnum property, BehaviorContext behaviorContext) {
        deviceBehaviorBinder.get(device).execute(property, behaviorContext);
    }

}
