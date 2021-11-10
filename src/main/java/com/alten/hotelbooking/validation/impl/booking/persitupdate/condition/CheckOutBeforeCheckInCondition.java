package com.alten.hotelbooking.validation.impl.booking.persitupdate.condition;

import com.alten.hotelbooking.persistence.entity.Booking;
import com.alten.hotelbooking.validation.Condition;
import org.springframework.stereotype.Component;

@Component
public class CheckOutBeforeCheckInCondition implements Condition<Booking> {
    @Override
    public Boolean isValid(Booking request) {
        return request.getCheckOutDate().isBefore(request.getCheckInDate());
    }
}
