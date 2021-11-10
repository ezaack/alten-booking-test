package com.alten.hotelbooking.controller;

import com.alten.hotelbooking.resources.request.CreateBookingRequest;
import com.alten.hotelbooking.resources.request.UpdateBookingRequest;
import com.alten.hotelbooking.resources.response.BookingResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/booking")
public interface PutBookingRestController {

    @PutMapping
    ResponseEntity<BookingResponse> put(@RequestBody UpdateBookingRequest body);
}
