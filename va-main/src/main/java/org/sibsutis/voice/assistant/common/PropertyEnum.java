package org.sibsutis.voice.assistant.common;


import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;

import static org.sibsutis.voice.assistant.common.CommandEnum.*;

public enum PropertyEnum {
    DEFAULT(StringUtils.EMPTY, Arrays.asList(TURN_ON, TURN_OFF))
    ;

    private String name;
    private List<CommandEnum> commands;

    PropertyEnum(String name, List<CommandEnum> commands) {
        this.name = name;
        this.commands = commands;
    }

    public String getName() {
        return name;
    }

    public List<CommandEnum> getCommands() {
        return commands;
    }
}
