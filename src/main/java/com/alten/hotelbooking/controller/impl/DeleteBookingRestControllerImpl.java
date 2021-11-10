package com.alten.hotelbooking.controller.impl;

import java.util.UUID;

import com.alten.hotelbooking.controller.DeleteBookingRestController;
import com.alten.hotelbooking.resources.response.BookingResponse;
import com.alten.hotelbooking.service.booking.CancelBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class DeleteBookingRestControllerImpl implements DeleteBookingRestController {
    @Autowired
    private CancelBookingService cancelBookingService;

    @Override
    public ResponseEntity delete(UUID bookingId) {
        cancelBookingService.cancel(bookingId);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
