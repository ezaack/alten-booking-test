package com.alten.hotelbooking.service.booking;

import java.util.UUID;

public interface CancelBookingService {

    void cancel(UUID bookingId);
}
