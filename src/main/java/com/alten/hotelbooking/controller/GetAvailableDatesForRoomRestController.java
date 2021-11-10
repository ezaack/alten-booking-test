package com.alten.hotelbooking.controller;

import java.util.List;

import com.alten.hotelbooking.resources.response.AvailabeBookingDatesResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/available-dates")
public interface GetAvailableDatesForRoomRestController {

    @GetMapping
    ResponseEntity<List<AvailabeBookingDatesResponse>> get();
}
