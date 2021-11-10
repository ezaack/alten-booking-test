package com.alten.hotelbooking.service.booking;

import java.util.Optional;

import com.alten.hotelbooking.resources.request.ReSecheduleBookingRequest;
import com.alten.hotelbooking.resources.response.BookingResponse;

public interface ReScheduleBookingService {

    Optional<BookingResponse> reSchedule(ReSecheduleBookingRequest reSecheduleBookingRequest);
}
