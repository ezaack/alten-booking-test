package com.alten.hotelbooking.converter;

import java.time.ZonedDateTime;
import java.util.stream.Collectors;

import com.alten.hotelbooking.enumerations.EnumBookingStatus;
import com.alten.hotelbooking.exception.BadRequestException;
import com.alten.hotelbooking.persistence.entity.Booking;
import com.alten.hotelbooking.persistence.entity.Gest;
import com.alten.hotelbooking.resources.request.CreateBookingRequest;
import com.alten.hotelbooking.resources.request.UpdateBookingRequest;
import com.alten.hotelbooking.service.room.FetchRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


//Did not make it as an abstract class to be able to inject the roomService
@Component
public class UpdateBookintRequestToEntityConverter {

    @Autowired
    private FetchRoomService fetchRoomService;
    @Value("${message.room.not.found}")
    private String invalidRoomNumberMessage;

    public Booking convert(UpdateBookingRequest request) {
        return request == null ? null : fetchRoomService.findByRoomNumber(request.getRoomNumber()).map(
                room -> Booking.builder()
                        .id(request.getId())
                        .bookingDateTime(ZonedDateTime.now())
                        .checkInDate(request.getCheckInDate())
                        .checkOutDate(request.getCheckOutDate())
                        .room(room)
                        .status(EnumBookingStatus.VALID)
                        .gests(
                                request.getGests().stream().map(
                                        gest ->
                                                Gest
                                                        .builder()
                                                        .age(gest.getAge())
                                                        .mainGest(gest.getMainGest())
                                                        .name(gest.getName())
                                                        .build()
                                ).collect(Collectors.toList())
                        )
                        .build()
        ).orElseThrow(
                () -> new BadRequestException(invalidRoomNumberMessage)
        );
    }
}
