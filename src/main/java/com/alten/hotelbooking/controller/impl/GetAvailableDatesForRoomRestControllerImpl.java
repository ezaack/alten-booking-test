package com.alten.hotelbooking.controller.impl;

import java.util.List;

import com.alten.hotelbooking.controller.GetAvailableDatesForRoomRestController;
import com.alten.hotelbooking.resources.response.AvailabeBookingDatesResponse;
import com.alten.hotelbooking.service.booking.FetchAvailableBookingDatesSErvice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetAvailableDatesForRoomRestControllerImpl implements GetAvailableDatesForRoomRestController {

    @Autowired
    private FetchAvailableBookingDatesSErvice fetchAvailableBookingDatesSErvice;


    @Override
    public ResponseEntity<List<AvailabeBookingDatesResponse>> get() {
        return ResponseEntity.ok(fetchAvailableBookingDatesSErvice.fetch());
    }
}
