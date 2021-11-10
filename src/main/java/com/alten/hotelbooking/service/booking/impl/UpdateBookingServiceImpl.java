package com.alten.hotelbooking.service.booking.impl;

import java.util.Optional;

import com.alten.hotelbooking.converter.BookingEntityToResponseConverter;
import com.alten.hotelbooking.converter.PersistBookintRequestToEntityConverter;
import com.alten.hotelbooking.converter.UpdateBookintRequestToEntityConverter;
import com.alten.hotelbooking.persistence.entity.Booking;
import com.alten.hotelbooking.persistence.repository.BookingRepository;
import com.alten.hotelbooking.resources.request.CreateBookingRequest;
import com.alten.hotelbooking.resources.request.UpdateBookingRequest;
import com.alten.hotelbooking.resources.response.BookingResponse;
import com.alten.hotelbooking.service.booking.NewBookingService;
import com.alten.hotelbooking.service.booking.UpdateBookingService;
import com.alten.hotelbooking.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UpdateBookingServiceImpl implements UpdateBookingService {

    private BookingRepository bookingRepository;
    private Validator newBookingValidator;
    private UpdateBookintRequestToEntityConverter updateBookintRequestToEntityConverter;

    @Autowired
    public UpdateBookingServiceImpl(
            BookingRepository bookingRepository,
            Validator newBookingValidator,
            UpdateBookintRequestToEntityConverter updateBookintRequestToEntityConverter
    ) {
        this.bookingRepository = bookingRepository;
        this.newBookingValidator = newBookingValidator;
        this.updateBookintRequestToEntityConverter = updateBookintRequestToEntityConverter;
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    @Override
    public Optional<BookingResponse> update(UpdateBookingRequest request) {
        Booking booking = updateBookintRequestToEntityConverter.convert(request);
        newBookingValidator.validate(booking);
        return Optional.of(BookingEntityToResponseConverter.convert(bookingRepository.save(booking)));
    }
}
