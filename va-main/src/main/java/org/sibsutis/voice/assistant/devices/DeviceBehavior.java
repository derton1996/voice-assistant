package org.sibsutis.voice.assistant.devices;

import org.sibsutis.voice.assistant.common.PropertyEnum;
import org.sibsutis.voice.assistant.devices.behavior.context.BehaviorContext;
import org.sibsutis.voice.assistant.devices.behavior.OnOffBehavior;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.util.EnumMap;
import java.util.function.Consumer;

public abstract class DeviceBehavior {

    protected final EnumMap<PropertyEnum, Consumer<BehaviorContext>> propertyMap = new EnumMap<>(PropertyEnum.class);

    protected OnOffBehavior onOffBehavior;

    @Autowired
    public void setOnOffBehavior(OnOffBehavior onOffBehavior) {
        this.onOffBehavior = onOffBehavior;
    }

    @PostConstruct
    public void init() {
        propertyMap.put(PropertyEnum.DEFAULT, onOffPropertyBehavior());
    }

    public void execute(PropertyEnum property, BehaviorContext behaviorContext) {
        propertyMap.get(property).accept(behaviorContext);
    }

    protected Consumer<BehaviorContext> onOffPropertyBehavior() {
        return behaviorContext -> onOffBehavior.toggle(behaviorContext);
    }

}
