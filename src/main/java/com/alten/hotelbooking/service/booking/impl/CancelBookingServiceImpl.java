package com.alten.hotelbooking.service.booking.impl;

import java.util.UUID;

import com.alten.hotelbooking.persistence.repository.BookingRepository;
import com.alten.hotelbooking.service.booking.CancelBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CancelBookingServiceImpl implements CancelBookingService {
    @Autowired
    private BookingRepository bookingRepository;

    @Transactional
    @Override
    public void cancel(UUID bookingId) {
        bookingRepository.cancelBooking(bookingId);
    }
}
