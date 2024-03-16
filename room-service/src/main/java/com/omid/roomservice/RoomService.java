package com.omid.roomservice;

import com.querydsl.core.BooleanBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoomService {
    private final RoomRepository roomRepository;
    private final QRoom qRoom = QRoom.room;

    public Room loadOne(String id) {
        return roomRepository.getRoomById(id);
    }

    public List<Room> loadAll() {
        return roomRepository.findAll();
    }

    public Room createRoom(Room room) {
        return roomRepository.save(room);
    }

    public Room updateRoom(String id, Room room) {
        Room dbRoom = loadOne(id);

        if (room.getTitle() != null) {
            dbRoom.setTitle(room.getTitle());
        }
        if (room.getType() != null) {
            dbRoom.setType(room.getType());
        }
        if (room.getPrice() != null) {
            dbRoom.setPrice(room.getPrice());
        }
        if (room.getStatus() != null) {
            dbRoom.setStatus(room.getStatus());
        }
        if (room.getFloor() != null) {
            dbRoom.setFloor(room.getFloor());
        }

        return roomRepository.saveAndFlush(dbRoom);

    }

    public Page<Room> search(RoomSearchFilter searchFilter, Pageable pageable) {
        BooleanBuilder predicate = new BooleanBuilder();

        if (searchFilter.getTitle() != null) {
            predicate.and(qRoom.title.contains(searchFilter.getTitle()));
        }
        if (searchFilter.getFloor() != null) {
            predicate.and(qRoom.floor.eq(searchFilter.getFloor()));
        }
        if (searchFilter.getPrice() != null) {
            predicate.and(qRoom.price.eq(searchFilter.getPrice()));
        }
        if (searchFilter.getStatus() != null) {
            predicate.and(qRoom.status.eq(searchFilter.getStatus()));
        }
        if (searchFilter.getType() != null) {
            predicate.and(qRoom.type.eq(searchFilter.getType()));
        }


        return roomRepository.findAll(predicate, pageable);

    }
}
