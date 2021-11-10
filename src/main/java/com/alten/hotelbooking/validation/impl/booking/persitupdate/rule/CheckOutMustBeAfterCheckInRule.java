package com.alten.hotelbooking.validation.impl.booking.persitupdate.rule;

import com.alten.hotelbooking.persistence.entity.Booking;
import com.alten.hotelbooking.validation.BaseAbstractRule;
import com.alten.hotelbooking.validation.impl.booking.persitupdate.condition.CheckOutBeforeCheckInCondition;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class CheckOutMustBeAfterCheckInRule extends BaseAbstractRule<Booking> {

    @Value("${message.rule.checkout.before.checkin}")
    public String checkoutBeforeCheckinMessage;

    public CheckOutMustBeAfterCheckInRule(
            CheckOutBeforeCheckInCondition checkOutBeforeCheckInCondition
    ){
        addCondition(checkOutBeforeCheckInCondition);
    }


    @Override
    protected String violationMessage(Booking request) {
        return checkoutBeforeCheckinMessage;
    }
}
