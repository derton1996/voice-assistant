package org.sibsutis.voice.assistant.devices.initializer;

import org.sibsutis.voice.assistant.common.DeviceEnum;
import org.sibsutis.voice.assistant.common.PropertyEnum;
import org.sibsutis.voice.assistant.devices.behavior.context.BehaviorContext;

public interface DeviceBehaviorBinder {

    void execute(DeviceEnum device, PropertyEnum property, BehaviorContext behaviorContext);

}
