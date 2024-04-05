package com.omid.guestservice;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/guests")
@RequiredArgsConstructor
public class GuestController {
    private final GuestService guestService;
    private final ServerProperties serverProperties;
    private final MongoTemplate mongoTemplate;

    @GetMapping
    public List<Guest> loadAllGuest() {
        return guestService.loadAllGuests();
    }

    @GetMapping("/load-one")
    public Guest loadOneGuest(@RequestParam("id") String id) {
        return guestService.loadOneGuest(id);
    }

    @GetMapping("/search")
    public List<Guest> searchGuest(@RequestParam("value") String value) {
        return guestService.searchGuest(value);
    }

    @PostMapping
    public Guest createGuest(@RequestBody Guest guest) {
        return guestService.createGuest(guest);
    }

    @PutMapping("/{id}")
    public Guest updateGuest(@PathVariable("id") String id, @RequestBody Guest guest) {
        return guestService.updateGuest(id,guest);
    }
}
