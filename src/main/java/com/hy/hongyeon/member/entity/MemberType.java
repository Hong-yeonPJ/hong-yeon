package com.hy.hongyeon.member.entity;

import lombok.Getter;

@Getter
public enum MemberType {
    CERTIFIED("CERTIFIED"),
    NON_CERTIFIED("NON_CERTIFIED");

    private final String value;

    MemberType(String value) {
        this.value = value;
    }
}