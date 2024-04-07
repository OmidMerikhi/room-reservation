package com.omid.roomreservationservice.client;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GuestServiceFallback implements GuestServiceClient{
    @Override
    public List<Guest> loadAllGuest() {
        return new ArrayList<>();
    }

    @Override
    public Guest loadOneGuest(String id) {
        return new Guest();
    }

    @Override
    public List<Guest> searchGuest(String value) {
        return new ArrayList<>();
    }

    @Override
    public Guest createGuest(Guest guest) {
        return new Guest();
    }

    @Override
    public Guest updateGuest(String id, Guest guest) {
        return new Guest();
    }
}
