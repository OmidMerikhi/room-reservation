package com.omid.reservationservice.reservation;

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
