package com.alten.hotelbooking.controller.impl;

import com.alten.hotelbooking.controller.PatchBookingRestController;
import com.alten.hotelbooking.controller.PutBookingRestController;
import com.alten.hotelbooking.resources.request.CreateBookingRequest;
import com.alten.hotelbooking.resources.request.ReSecheduleBookingRequest;
import com.alten.hotelbooking.resources.response.BookingResponse;
import com.alten.hotelbooking.service.booking.ReScheduleBookingService;
import com.alten.hotelbooking.service.booking.UpdateBookingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PatchBookingRestControllerImpl implements PatchBookingRestController {
    private ReScheduleBookingService reScheduleBookingService;

    public PatchBookingRestControllerImpl(
            ReScheduleBookingService reScheduleBookingService
    ) {
        this.reScheduleBookingService = reScheduleBookingService;
    }

    @Override
    public ResponseEntity<BookingResponse> patch(@RequestBody ReSecheduleBookingRequest body) {
        return ResponseEntity.of(reScheduleBookingService.reSchedule(body));
    }
}
