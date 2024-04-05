package com.omid.roomservice.room;

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

    public Room loadOne(String id){
        return roomRepository.getRoomById(id);
    }

    public List<Room> loadAll(){
        return roomRepository.findAll();
    }

    public Room create(Room room){
        return roomRepository.save(room);
    }

    public Room update(String id, Room room){
        Room roomDb=loadOne(id);

        if(room.getTitle()!=null){
            roomDb.setTitle(room.getTitle());
        };
        if(room.getReserveInfo()!=null){
            roomDb.setReserveInfo(room.getReserveInfo());
        };
        if(room.getActive()!=null){
            roomDb.setActive(room.getActive());
        };
        if(room.getVacancy()!=null){
            roomDb.setVacancy(room.getVacancy());
        };
        if(room.getRoomType()!=null){
            roomDb.setRoomType(room.getRoomType());
        };

        return roomRepository.saveAndFlush(roomDb);
    }

    public Page<Room> search(RoomSearchFilter searchFilter, Pageable pageable){

        BooleanBuilder predicate=new BooleanBuilder();

        if(searchFilter.getTitle()!=null){
            predicate.and(qRoom.title.contains(searchFilter.getTitle()));
        }

        if(searchFilter.getReserveInfo()!=null){
            predicate.and(qRoom.reserveInfo.contains(searchFilter.getReserveInfo()));
        }

        if(searchFilter.getActive()!=null){
            predicate.and(qRoom.active.eq(searchFilter.getActive()));
        }

        if(searchFilter.getVacancy()!=null){
            predicate.and(qRoom.vacancy.eq(searchFilter.getVacancy()));
        }

        if(searchFilter.getRoomType()!=null){
            predicate.and(qRoom.roomType.eq(searchFilter.getRoomType()));
        }

        return roomRepository.findAll(predicate, pageable);

    }
}
