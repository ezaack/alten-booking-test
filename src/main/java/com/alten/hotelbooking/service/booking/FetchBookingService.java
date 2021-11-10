package com.alten.hotelbooking.service.booking;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.alten.hotelbooking.resources.filter.BookingFilter;
import com.alten.hotelbooking.resources.response.BookingResponse;

public interface FetchBookingService {
    List<BookingResponse> find(BookingFilter request);
    Optional<BookingResponse> find(UUID bookingId);
}
