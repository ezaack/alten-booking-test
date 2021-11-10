package com.alten.hotelbooking.service.booking.impl;

import java.util.Optional;

import com.alten.hotelbooking.converter.BookingEntityToResponseConverter;
import com.alten.hotelbooking.exception.BadRequestException;
import com.alten.hotelbooking.persistence.repository.BookingRepository;
import com.alten.hotelbooking.resources.request.ReSecheduleBookingRequest;
import com.alten.hotelbooking.resources.response.BookingResponse;
import com.alten.hotelbooking.service.booking.ReScheduleBookingService;
import com.alten.hotelbooking.service.booking.UpdateBookingService;
import com.alten.hotelbooking.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ReScheduleBookingServiceImpl implements ReScheduleBookingService {
    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private UpdateBookingService updateBookingService;
    @Autowired
    private Validator newBookingValidator;
    @Value("${message.booking.not.found}")
    private String bookingIdInvalidMessage;

    @Transactional(isolation = Isolation.SERIALIZABLE)
    @Override
    public Optional<BookingResponse> reSchedule(ReSecheduleBookingRequest reSecheduleBookingRequest) {
        return bookingRepository.findById(reSecheduleBookingRequest.getId()).map(
                booking -> {
                    booking.setCheckInDate(reSecheduleBookingRequest.getCheckInDate());
                    booking.setCheckOutDate(reSecheduleBookingRequest.getCheckOutDate());
                    newBookingValidator.validate(booking);
                    return Optional.of(BookingEntityToResponseConverter.convert(bookingRepository.save(booking)));
                }
        ).orElseThrow(
                () -> new BadRequestException(bookingIdInvalidMessage)
        );
    }
}
