package com.omid.roomservice;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoomMapping extends EntityMapper<RoomDto, Room> {
    RoomDto toViewModel(Room room);
    Room toEntity(RoomDto roomDto);
}
