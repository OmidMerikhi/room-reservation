package com.omid.roomservice.room;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<Room, String>, QuerydslPredicateExecutor<Room> {
    Room getRoomById(String id);
}
