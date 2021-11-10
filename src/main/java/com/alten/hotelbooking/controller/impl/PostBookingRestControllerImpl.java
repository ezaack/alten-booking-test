package com.alten.hotelbooking.controller.impl;

import com.alten.hotelbooking.controller.PostBookingRestController;
import com.alten.hotelbooking.exception.UnexpectedRequestException;
import com.alten.hotelbooking.resources.request.CreateBookingRequest;
import com.alten.hotelbooking.resources.response.BookingResponse;
import com.alten.hotelbooking.service.booking.NewBookingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostBookingRestControllerImpl implements PostBookingRestController {
    private NewBookingService newBookingService;

    public PostBookingRestControllerImpl(
            NewBookingService newBookingService
    ) {
        this.newBookingService = newBookingService;
    }

    @Override
    public ResponseEntity<BookingResponse> post(@RequestBody CreateBookingRequest body) {
        return newBookingService.persist(body).map(response -> ResponseEntity.status(HttpStatus.CREATED).body(response)).orElseThrow(
                () -> new UnexpectedRequestException()
        );
    }
}
