package com.alten.hotelbooking.service.booking;

import java.util.Optional;

import com.alten.hotelbooking.resources.request.UpdateBookingRequest;
import com.alten.hotelbooking.resources.response.BookingResponse;

public interface UpdateBookingService {
    Optional<BookingResponse> update(UpdateBookingRequest request);
}
