package com.alten.hotelbooking.converter;

import java.time.ZonedDateTime;
import java.util.stream.Collectors;

import com.alten.hotelbooking.enumerations.EnumBookingStatus;
import com.alten.hotelbooking.exception.BadRequestException;
import com.alten.hotelbooking.persistence.entity.Booking;
import com.alten.hotelbooking.persistence.entity.Gest;
import com.alten.hotelbooking.resources.request.CreateBookingRequest;
import com.alten.hotelbooking.service.room.FetchRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


//Did not make it as an abstract class to be able to inject the roomService
@Component
public class PersistBookintRequestToEntityConverter {

    @Autowired
    private FetchRoomService fetchRoomService;
    @Value("${message.room.not.found}")
    private String invalidRoomNumberMessage;

    public Booking convert(CreateBookingRequest request) {
        return request == null ? null : fetchRoomService.findByRoomNumber(request.getRoomNumber()).map(
                room -> {
                    Booking booking = Booking.builder()
                            .bookingDateTime(ZonedDateTime.now())
                            .checkInDate(request.getCheckInDate())
                            .checkOutDate(request.getCheckOutDate())
                            .room(room)
                            .status(EnumBookingStatus.VALID)
                            .build();

                    booking.setGests(
                            request.getGests().stream().map(
                                    gest ->
                                            Gest
                                                    .builder()
                                                    .age(gest.getAge())
                                                    .mainGest(gest.getMainGest())
                                                    .name(gest.getName())
                                                    .booking(booking)
                                                    .build()
                            ).collect(Collectors.toList())
                    );
                    return booking;
                }
        ).orElseThrow(
                () -> new BadRequestException(invalidRoomNumberMessage)
        );
    }
}
