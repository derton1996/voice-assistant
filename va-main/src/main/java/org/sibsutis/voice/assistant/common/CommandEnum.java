package org.sibsutis.voice.assistant.common;

public enum CommandEnum {
    TURN_ON("включить"),
    TURN_OFF("выключить"),
    INCREASE("увеличить"),
    DECREASE("уменьшить")
    ;


    private final String name;

    CommandEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public CommandEnum getByName(String name) {
        for (CommandEnum commandEnum : values()) {
            if (commandEnum.getName().equals(name)) {
                return commandEnum;
            }
        }

        return null;
    }

}
