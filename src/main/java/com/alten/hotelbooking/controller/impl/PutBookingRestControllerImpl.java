package com.alten.hotelbooking.controller.impl;

import com.alten.hotelbooking.controller.PutBookingRestController;
import com.alten.hotelbooking.resources.request.UpdateBookingRequest;
import com.alten.hotelbooking.resources.response.BookingResponse;
import com.alten.hotelbooking.service.booking.UpdateBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PutBookingRestControllerImpl implements PutBookingRestController {
    @Autowired
    private UpdateBookingService updateBookingService;

    @Override
    public ResponseEntity<BookingResponse> put(@RequestBody UpdateBookingRequest body) {
        return ResponseEntity.of(updateBookingService.update(body));
    }
}
