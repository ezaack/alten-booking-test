package com.alten.hotelbooking.service.booking;

import java.util.Optional;

import com.alten.hotelbooking.resources.request.CreateBookingRequest;
import com.alten.hotelbooking.resources.response.BookingResponse;

public interface NewBookingService {

    Optional<BookingResponse> persist(CreateBookingRequest request);
}
