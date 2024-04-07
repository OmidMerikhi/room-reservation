package com.omid.roomreservationservice.client;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReservationFallback implements ReserveationServiceClient{
    @Override
    public List<ReservationDto> getAllReservations() {
        return new ArrayList<>();
    }

    @Override
    public List<ReservationDto> search(Long from, Long to) {
        return new ArrayList<>();
    }

    @Override
    public ReservationDto createReservation(String guestId, String roomId, Long from, Long to) {
        return new ReservationDto();
    }
}
