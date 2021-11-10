package com.alten.hotelbooking.persistence.repository;

import java.util.Optional;
import java.util.UUID;

import com.alten.hotelbooking.persistence.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, UUID> {

    Optional<Room> findByNumber(Integer number);
}
