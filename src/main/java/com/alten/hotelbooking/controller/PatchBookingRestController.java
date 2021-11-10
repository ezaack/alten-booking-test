package com.alten.hotelbooking.controller;

import com.alten.hotelbooking.resources.request.CreateBookingRequest;
import com.alten.hotelbooking.resources.request.ReSecheduleBookingRequest;
import com.alten.hotelbooking.resources.response.BookingResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/booking")
public interface PatchBookingRestController {

    @PatchMapping
    ResponseEntity<BookingResponse> patch(@RequestBody ReSecheduleBookingRequest body);
}
