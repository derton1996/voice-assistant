package org.sibsutis.voice.assistant.common;

import java.util.Arrays;
import java.util.List;

import static org.sibsutis.voice.assistant.common.PropertyEnum.*;

public enum DeviceEnum {

    BRAILLE_BOARD("брайльборд", Arrays.asList(DEFAULT));

    private String name;
    private List<PropertyEnum> properties;

    DeviceEnum(String name, List<PropertyEnum> properties) {
        this.name = name;
        this.properties = properties;
    }

    public String getName() {
        return name;
    }

    public List<PropertyEnum> getProperties() {
        return properties;
    }

    public DeviceEnum getByName(String name) {
        for (DeviceEnum deviceEnum : values()) {
            if (deviceEnum.getName().equals(name)) {
                return deviceEnum;
            }
        }

        return null;
    }

}
