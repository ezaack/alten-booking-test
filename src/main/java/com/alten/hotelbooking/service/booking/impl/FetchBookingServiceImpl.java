package com.alten.hotelbooking.service.booking.impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import com.alten.hotelbooking.converter.BookingEntityToResponseConverter;
import com.alten.hotelbooking.persistence.repository.BookingRepository;
import com.alten.hotelbooking.resources.filter.BookingFilter;
import com.alten.hotelbooking.resources.response.BookingResponse;
import com.alten.hotelbooking.service.booking.FetchBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FetchBookingServiceImpl implements FetchBookingService {
    @Autowired
    private BookingRepository bookingRepository;

    @Override
    public List<BookingResponse> find(BookingFilter request) {
        return bookingRepository.findByRoomNumberMinCheckInAndMaxChein(request.getRoomNumber(), request.getMinCheckIn(), request.getMaxCheckIn())
                .stream()
                .map(BookingEntityToResponseConverter::convert)
                .collect(Collectors.toList());
    }

    @Transactional
    @Override
    public Optional<BookingResponse> find(UUID bookingId) {
        return bookingRepository.findById(bookingId).map(
                BookingEntityToResponseConverter::convert
        );
    }
}
