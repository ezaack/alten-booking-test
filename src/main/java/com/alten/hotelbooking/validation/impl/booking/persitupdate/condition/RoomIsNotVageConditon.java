package com.alten.hotelbooking.validation.impl.booking.persitupdate.condition;

import java.util.stream.Collectors;

import com.alten.hotelbooking.persistence.entity.Booking;
import com.alten.hotelbooking.persistence.repository.BookingRepository;
import com.alten.hotelbooking.validation.Condition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RoomIsNotVageConditon implements Condition<Booking> {

    @Autowired
    private BookingRepository bookingRepository;

    @Override
    public Boolean isValid(Booking request) {
        return !bookingRepository.findShockingDatesDyRoomNumber(request.getRoom().getNumber(), request.getCheckInDate(), request.getCheckOutDate()).stream()
                .filter(
                        booking -> request.getId() == null || !booking.getId().equals(request.getId())
                ).collect(Collectors.toList()).isEmpty();
    }
}
