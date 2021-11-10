package com.alten.hotelbooking.controller.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import com.alten.hotelbooking.controller.GetBookingRestController;
import com.alten.hotelbooking.resources.filter.BookingFilter;
import com.alten.hotelbooking.resources.response.BookingResponse;
import com.alten.hotelbooking.service.booking.FetchBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetBookingRestControllerImpl implements GetBookingRestController {
    @Autowired
    private FetchBookingService fetchBookingService;

    @Override
    public ResponseEntity<List<BookingResponse>> get(Integer roomNumber, String minCheckIn, String maxCheckIn) {
        return ResponseEntity.ok(fetchBookingService.find(
                BookingFilter.builder()
                        .roomNumber(roomNumber)
                        .minCheckIn(LocalDate.parse(minCheckIn))
                        .maxCheckIn(LocalDate.parse(maxCheckIn))
                        .build()
        ));
    }

    @Override
    public ResponseEntity<BookingResponse> get(UUID bookingId) {
        return ResponseEntity.of(fetchBookingService.find(bookingId));
    }
}
