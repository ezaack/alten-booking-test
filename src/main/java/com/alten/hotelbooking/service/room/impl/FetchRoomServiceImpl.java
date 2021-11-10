package com.alten.hotelbooking.service.room.impl;

import java.util.List;
import java.util.Optional;

import com.alten.hotelbooking.persistence.entity.Room;
import com.alten.hotelbooking.persistence.repository.RoomRepository;
import com.alten.hotelbooking.service.room.FetchRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FetchRoomServiceImpl implements FetchRoomService {
    @Autowired
    private RoomRepository roomRepository;

    @Override
    public Optional<Room> findByRoomNumber(Integer roomNumber) {
        return roomRepository.findByNumber(roomNumber);
    }

    @Override
    public List<Room> findAll() {
        return roomRepository.findAll();
    }
}
