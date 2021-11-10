package com.alten.hotelbooking.validation.impl.booking.persitupdate.rule;

import com.alten.hotelbooking.persistence.entity.Booking;
import com.alten.hotelbooking.resources.request.UpdateBookingRequest;
import com.alten.hotelbooking.validation.BaseAbstractRule;
import com.alten.hotelbooking.validation.impl.booking.persitupdate.condition.BookingPeriodBiggerThanThreeDaysCondition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MaxThreeDaysBookingRule extends BaseAbstractRule<Booking> {
    private final String violationMessage;

    @Autowired
    public MaxThreeDaysBookingRule(
            BookingPeriodBiggerThanThreeDaysCondition bookingPeriodBiggerThanThreeDaysCondition,
            @Value("${message.rule.maxdaysbooking}") String violationMessage
    ) {
        addCondition(bookingPeriodBiggerThanThreeDaysCondition);
        this.violationMessage = violationMessage;
    }

    @Override
    protected String violationMessage(Booking request) {
        return violationMessage;
    }
}
