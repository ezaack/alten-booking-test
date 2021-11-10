package com.alten.hotelbooking.validation.impl.booking.persitupdate.rule;

import com.alten.hotelbooking.persistence.entity.Booking;
import com.alten.hotelbooking.resources.request.UpdateBookingRequest;
import com.alten.hotelbooking.validation.BaseAbstractRule;
import com.alten.hotelbooking.validation.impl.booking.persitupdate.condition.BookingCheckInIsNotAfterBookingDateCondition;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class CheckInDateBustBeAfterBookingDateRule extends BaseAbstractRule<Booking> {

    @Value("${message.rule.checkin.date.invalid}")
    private String violationMessage;

    public CheckInDateBustBeAfterBookingDateRule(
            BookingCheckInIsNotAfterBookingDateCondition bookingCheckInIsNotAfterBookingDateCondition
    ){
        addCondition(bookingCheckInIsNotAfterBookingDateCondition);
    }

    @Override
    protected String violationMessage(Booking request) {
        return violationMessage;
    }
}
