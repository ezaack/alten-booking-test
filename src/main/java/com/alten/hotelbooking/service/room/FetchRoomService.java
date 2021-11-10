package com.alten.hotelbooking.service.room;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.alten.hotelbooking.persistence.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FetchRoomService {

    Optional<Room> findByRoomNumber(Integer roomNumber);
    List<Room> findAll();
}
