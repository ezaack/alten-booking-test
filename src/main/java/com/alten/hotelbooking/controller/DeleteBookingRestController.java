package com.alten.hotelbooking.controller;

import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/booking")
public interface DeleteBookingRestController {

    @DeleteMapping("/{bookingId}")
    ResponseEntity delete(@PathVariable("bookingId") UUID bookingId);
}
