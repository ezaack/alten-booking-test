package com.alten.hotelbooking.converter;

import java.util.stream.Collectors;

import com.alten.hotelbooking.persistence.entity.Booking;
import com.alten.hotelbooking.resources.response.BookingResponse;
import com.alten.hotelbooking.resources.response.GestResponse;

public final class BookingEntityToResponseConverter {

    public static BookingResponse convert(Booking booking) {
        return booking == null ? null : BookingResponse.builder()
                .id(booking.getId())
                .bookingDateTime(booking.getBookingDateTime())
                .checkInDate(booking.getCheckInDate())
                .checkOutDate(booking.getCheckOutDate())
                .gests(
                        booking.getGests().stream().map(
                                gest ->
                                        GestResponse
                                                .builder()
                                                .age(gest.getAge())
                                                .id(gest.getId())
                                                .mainGest(gest.getMainGest())
                                                .name(gest.getName())
                                                .build()
                        ).collect(Collectors.toList())
                )
                .roomNumber(booking.getRoom().getNumber())
                .build();
    }
}
