package com.nesterrovv.data;

public enum EyeColor {
    GREEN("GREEN EYES"),
    RED("RED EYES"),
    BLUE("BLUE EYES");

    private final String stringRepresentation;

    EyeColor(String stringRepresentation) {
        this.stringRepresentation = stringRepresentation;
    }

    @Override
    public String toString() {
        return this.stringRepresentation;
    }

}
