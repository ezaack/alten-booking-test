package com.alten.hotelbooking.validation.impl.booking.persitupdate.condition;

import java.time.temporal.ChronoUnit;

import com.alten.hotelbooking.persistence.entity.Booking;
import com.alten.hotelbooking.resources.request.CreateBookingRequest;
import com.alten.hotelbooking.resources.request.UpdateBookingRequest;
import com.alten.hotelbooking.validation.Condition;
import org.springframework.stereotype.Component;

@Component
public class BookingPeriodBiggerThanThreeDaysCondition implements Condition<Booking> {


    @Override
    public Boolean isValid(Booking request) {
        return ChronoUnit.DAYS.between(request.getCheckInDate(), request.getCheckOutDate()) > 2L;
    }
}
