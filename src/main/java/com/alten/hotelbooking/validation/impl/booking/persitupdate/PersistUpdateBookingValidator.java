package com.alten.hotelbooking.validation.impl.booking.persitupdate;

import com.alten.hotelbooking.persistence.entity.Booking;
import com.alten.hotelbooking.validation.BaseAbstractValidator;
import com.alten.hotelbooking.validation.impl.booking.persitupdate.rule.CheckInDateBustBeAfterBookingDateRule;
import com.alten.hotelbooking.validation.impl.booking.persitupdate.rule.CheckOutMustBeAfterCheckInRule;
import com.alten.hotelbooking.validation.impl.booking.persitupdate.rule.MaxThreeDaysBookingRule;
import com.alten.hotelbooking.validation.impl.booking.persitupdate.rule.RoomMustBeVageRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PersistUpdateBookingValidator extends BaseAbstractValidator<Booking> {

    @Autowired
    public PersistUpdateBookingValidator(
            RoomMustBeVageRule roomMustBeVageRule,
            MaxThreeDaysBookingRule maxThreeDaysBookingRule,
            CheckOutMustBeAfterCheckInRule checkOutMustBeAfterCheckInRule,
            CheckInDateBustBeAfterBookingDateRule checkInDateBustBeAfterBookingDateRule
    ) {
        addRule(roomMustBeVageRule);
        addRule(maxThreeDaysBookingRule);
        addRule(checkOutMustBeAfterCheckInRule);
        addRule(checkInDateBustBeAfterBookingDateRule);
    }
}
