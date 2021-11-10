package com.alten.hotelbooking.controller;

import com.alten.hotelbooking.resources.request.CreateBookingRequest;
import com.alten.hotelbooking.resources.response.BookingResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/booking")
public interface PostBookingRestController {

    @PostMapping
    ResponseEntity<BookingResponse> post(@RequestBody CreateBookingRequest body);
}
