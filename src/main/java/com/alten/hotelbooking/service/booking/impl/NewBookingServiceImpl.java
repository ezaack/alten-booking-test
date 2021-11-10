package com.alten.hotelbooking.service.booking.impl;

import java.util.Optional;

import com.alten.hotelbooking.converter.BookingEntityToResponseConverter;
import com.alten.hotelbooking.converter.PersistBookintRequestToEntityConverter;
import com.alten.hotelbooking.persistence.entity.Booking;
import com.alten.hotelbooking.persistence.repository.BookingRepository;
import com.alten.hotelbooking.resources.request.CreateBookingRequest;
import com.alten.hotelbooking.resources.response.BookingResponse;
import com.alten.hotelbooking.service.booking.NewBookingService;
import com.alten.hotelbooking.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class NewBookingServiceImpl implements NewBookingService {

    private BookingRepository bookingRepository;
    private Validator newBookingValidator;
    private PersistBookintRequestToEntityConverter persistBookintRequestToEntityConverter;

    @Autowired
    public NewBookingServiceImpl(
            BookingRepository bookingRepository,
            Validator newBookingValidator,
            PersistBookintRequestToEntityConverter persistBookintRequestToEntityConverter
    ) {
        this.bookingRepository = bookingRepository;
        this.newBookingValidator = newBookingValidator;
        this.persistBookintRequestToEntityConverter = persistBookintRequestToEntityConverter;
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    @Override
    public Optional<BookingResponse> persist(CreateBookingRequest request) {
        Booking booking = persistBookintRequestToEntityConverter.convert(request);
        newBookingValidator.validate(booking);
        return Optional.of(BookingEntityToResponseConverter.convert(bookingRepository.save(booking)));
    }
}
