package com.omid.roomreservationservice.client;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/client")
@RequiredArgsConstructor
public class RoomReservationController {
    private final GuestServiceClient guestServiceClient;
    private final RoomServiceClient roomServiceClient;
    private final ReserveationServiceClient reserveationServiceClient;

    @GetMapping("/room/search")
    public Page<Room> searchRooms(RoomSearchFilter searchFilter, Pageable pageable) {
        return roomServiceClient.search(searchFilter, pageable);
    }

    @GetMapping("/rooms")
    public List<Room> getRooms() {
        return roomServiceClient.getAllRooms();
    }

    @PostMapping("/room/add")
    public Room addRoom(@RequestBody Room room) {
        return roomServiceClient.createRoom(room);
    }

    @GetMapping("/guest/search")
    public List<Guest> searchGuest(@RequestParam("value") String value) {
        return guestServiceClient.searchGuest(value);
    }

    @PostMapping("/guest/add")
    public Guest addGuest(@RequestBody Guest guest) {
        return guestServiceClient.createGuest(guest);
    }

    @GetMapping("/reservation/load-all")
    public List<ReservationDto> getAllReservation() {
        return reserveationServiceClient.getAllReservations();
    }

    @PostMapping("/reservation/add")
    public ReservationDto addReservation(@RequestParam("guest-id") String guestId,
                                         @RequestParam("room-id") String roomId,
                                         @RequestParam("from") Long from,
                                         @RequestParam("to") Long to) {
        return reserveationServiceClient.createReservation(guestId, roomId, from, to);
    }

    @GetMapping("/reservation/search")
    public List<ReservationDto> searchReservation(@RequestParam("from") Long from,
                                                  @RequestParam("to") Long to) {
        return reserveationServiceClient.search(from, to);
    }


}
