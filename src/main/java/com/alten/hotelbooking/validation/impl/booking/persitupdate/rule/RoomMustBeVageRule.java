package com.alten.hotelbooking.validation.impl.booking.persitupdate.rule;

import com.alten.hotelbooking.persistence.entity.Booking;
import com.alten.hotelbooking.resources.request.UpdateBookingRequest;
import com.alten.hotelbooking.validation.BaseAbstractRule;
import com.alten.hotelbooking.validation.impl.booking.persitupdate.condition.RoomIsNotVageConditon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class RoomMustBeVageRule extends BaseAbstractRule<Booking> {

    private final String violationMessage;

    @Autowired
    public RoomMustBeVageRule(RoomIsNotVageConditon roomIsNotVageConditon,
                              @Value("${message.rule.roomnotvage}") String violationMessage) {
        this.violationMessage = violationMessage;
        addCondition(roomIsNotVageConditon);
    }

    @Override
    protected String violationMessage(Booking request) {
        return violationMessage;
    }
}
