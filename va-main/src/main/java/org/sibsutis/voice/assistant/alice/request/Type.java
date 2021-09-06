package org.sibsutis.voice.assistant.alice.request;

public enum Type {
    SIMPLE_UTTERANCE("SimpleUtterance"),
    BUTTON_PRESSED("ButtonPressed"),
    PURCHASE_CONFIRMATION("Purchase.Confirmation"),
    SHOW_PULL("Show.Pull")
    ;

    private String name;

    Type(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static Type getByName(String name) {
        for (Type type : Type.values()) {
            if (type.getName().equals(name)) {
                return type;
            }
        }
        return null;
    }

}
