package com.hy.hongyeon.event.entity;

import lombok.Getter;

@Getter
public enum EventStatus {
    AVAILABLE("AVAILABLE"),
    NOT_AVAILABLE("NOT_AVAILABLE");

    private final String value;

    EventStatus(String value) {
        this.value = value;
    }
}
