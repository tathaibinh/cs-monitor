package org.game.cs.core.model.enums;

public enum RconCommand {

    CHANGE_MAP("changelevel "),

    MAP_LIST("maps *");

    private String value;

    private RconCommand(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}