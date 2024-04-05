package com.omid.roomservice.room;

import lombok.RequiredArgsConstructor;
import org.hibernate.query.sql.internal.ParameterRecognizerImpl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rooms")
@RequiredArgsConstructor
public class RoomController {
    private final RoomService roomService;
    private final RoomMapper roomMapper;

    @GetMapping
    public List<RoomDto> getAllRooms() {
        return roomMapper.toViewModel(roomService.loadAll());
    }

    @GetMapping("/{id}")
    public Room getRoomById(@PathVariable String id) {
        return roomService.loadOne(id);
    }

    @PostMapping
    public RoomDto createRoom(@RequestBody RoomDto roomDto) {
        return roomMapper.toViewModel(roomService.create(roomMapper.toEntity(roomDto)));
    }

    @PutMapping("/{id}")
    public RoomDto updateRoom(@PathVariable String id, @RequestBody RoomDto roomDto) {
        return roomMapper.toViewModel(roomService.update(id, roomMapper.toEntity(roomDto)));
    }

    @GetMapping("/search")
    public Page<Room> search(RoomSearchFilter searchFilter, Pageable pageable){
        return roomService.search(searchFilter, pageable);
    }


}
