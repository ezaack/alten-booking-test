package com.alten.hotelbooking.validation.impl.booking.persitupdate.condition;

import java.time.LocalDate;

import com.alten.hotelbooking.persistence.entity.Booking;
import com.alten.hotelbooking.resources.request.CreateBookingRequest;
import com.alten.hotelbooking.resources.request.UpdateBookingRequest;
import com.alten.hotelbooking.validation.Condition;
import org.springframework.stereotype.Component;

@Component
public class BookingCheckInIsNotAfterBookingDateCondition implements Condition<Booking> {


    @Override
    public Boolean isValid(Booking request) {
        LocalDate today = LocalDate.now();
        return request.getCheckInDate().equals(today) || request.getCheckInDate().isBefore(today);
    }
}
