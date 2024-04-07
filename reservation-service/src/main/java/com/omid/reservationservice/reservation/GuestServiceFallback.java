package com.omid.reservationservice.reservation;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class GuestServiceFallback implements GuestServiceClient {
    @Override
    public List<Guest> loadAllGuest() {
        return new ArrayList<>();
    }

    @Override
    public Guest loadGuestById(String id) {
        return new Guest();
    }
}
