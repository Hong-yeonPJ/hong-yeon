package com.hy.hongyeon.member.entity;

import lombok.Getter;

@Getter
public enum MemberRole {
    MEMBER("MEMBER"),
    ADMIN("ADMIN"),
    EVENT_HOST("EVENT_HOST");

    private final String value;

    MemberRole(String value) {
        this.value = value;
    }
}
