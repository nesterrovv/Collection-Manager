package com.nesterrovv.data;

import java.io.Serializable;

public enum Country
        implements Serializable {

    GERMANY("GERMANY"),
    CHINA("CHINA"),
    NORTH_KOREA("NORTH_KOREA");

    private final String stringRepresentation;

    private Country(String stringRepresentation) {
        this.stringRepresentation = stringRepresentation;
    }

    @Override
    public String toString() {
        return this.stringRepresentation;
    }

}