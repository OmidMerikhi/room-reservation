package com.omid.roomservice;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/rooms")
public class RoomController {
    private final RoomService roomService;
    private final RoomMapping roomMapping;

    @GetMapping
    public List<Room> loadAll() {
        return roomService.loadAll();
    }

    @GetMapping("/{id}")
    public RoomDto loadOne(@PathVariable("id") String id) {
        return roomMapping.toViewModel(roomService.loadOne(id));
    }

    @PostMapping
    public RoomDto create(@RequestBody RoomDto room) {
        return roomMapping.toViewModel(roomService.createRoom(roomMapping.toEntity(room)));
    }

    @PutMapping("/{id}")
    public RoomDto update(@PathVariable("id") String id, @RequestBody RoomDto room) {
        return roomMapping.toViewModel(roomService.updateRoom(id, roomMapping.toEntity(room)));
    }

    @GetMapping("/search")
    public Page<Room> search(RoomSearchFilter searchFilter, Pageable pageable) {
        return roomService.search(searchFilter, pageable);
    }


}
