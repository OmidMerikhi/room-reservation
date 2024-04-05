package com.omid.roomservice.room;

import com.omid.roomservice.util.EntityMapper;
import lombok.Data;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RoomMapper extends EntityMapper<RoomDto, Room> {
    RoomDto toViewModel(Room room);
    Room toEntity(RoomDto roomDto);


}
