package com.omid.roomreservationservice.client;

import lombok.Getter;

@Getter
public enum PersonType {
    GUEST("مهمان"),
    EMPLOYEE("کارمند");
    final String value;
    PersonType(String value) {
        this.value=value;
    }
}
