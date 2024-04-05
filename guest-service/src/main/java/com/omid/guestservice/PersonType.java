package com.omid.guestservice;

import lombok.Getter;

@Getter
public enum PersonType {
    GUEST("مهمان"),
    EMPLOYEE("کارمند");
    private final String value;
    PersonType(String value) {
        this.value=value;
    }
}
