package com.nesterrovv.data;

public enum HairColor {
    BLUE("BLUE HAIR"),
    YELLOW("YELLOW HAIR"),
    ORANGE("ORANGE HAIR");

    private final String stringRepresentation;

    private HairColor(String stringRepresentation) {
        this.stringRepresentation = stringRepresentation;
    }

    @Override
    public String toString() {
        return this.stringRepresentation;
    }

}