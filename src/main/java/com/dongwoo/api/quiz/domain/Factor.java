package com.dongwoo.api.quiz.domain;

public enum Factor {
    MINIMUM, MAXIMUM;

    @Override
    public String toString() {
        String value = "";

        switch (this) {
            case MINIMUM:
                return String.valueOf(11);
            case MAXIMUM:
                return String.valueOf(99);
            default:
                return value;
        }
    }
}
