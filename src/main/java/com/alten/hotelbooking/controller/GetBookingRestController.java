package com.alten.hotelbooking.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import com.alten.hotelbooking.resources.response.BookingResponse;
import io.swagger.annotations.ApiParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/booking")
public interface GetBookingRestController {

    @GetMapping
    ResponseEntity<List<BookingResponse>>  get(
            @RequestParam(value = "roomNumber") Integer roomNumber,
            @RequestParam("minCheckIn") @ApiParam(example = "yyyy-MM-dd") String minCheckIn,
            @RequestParam("maxCheckIn") @ApiParam(example = "yyyy-MM-dd") String maxCheckIn
    );

    @GetMapping("/{bookingId}")
    ResponseEntity<BookingResponse> get(
            @PathVariable("bookingId") UUID bookingId
    );
}
