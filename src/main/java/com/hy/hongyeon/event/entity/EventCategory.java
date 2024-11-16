package com.hy.hongyeon.event.entity;

import lombok.Getter;

@Getter
public enum EventCategory {
    PERFORMANCE("PERFORMANCE"),
    PUB("PUB"),
    UNIVERSITY_EVENT("UNIVERSITY_EVENT");

    private final String value;

    EventCategory(String value) {
        this.value = value;
    }

}
