package com.alten.hotelbooking.service.booking.impl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.alten.hotelbooking.helper.CreateAListOfDatesHelper;
import com.alten.hotelbooking.persistence.entity.Booking;
import com.alten.hotelbooking.persistence.repository.BookingRepository;
import com.alten.hotelbooking.resources.response.AvailabeBookingDatesResponse;
import com.alten.hotelbooking.service.booking.FetchAvailableBookingDatesSErvice;
import com.alten.hotelbooking.service.room.FetchRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FetchAvailableBookingDatesSErviceImpl implements FetchAvailableBookingDatesSErvice {

    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private FetchRoomService fetchRoomService;


    @Override
    public List<AvailabeBookingDatesResponse> fetch() {

        Set<LocalDate> dates = new HashSet<>();
        LocalDate maxDate = LocalDate.now().plusDays(30L);
        CreateAListOfDatesHelper.getNextDays(LocalDate.now(), maxDate, dates);

        return fetchRoomService.findAll().stream().map(
                room -> {
                    List<Booking> bookinkgs = bookingRepository.findByNumberRoomAndInterval(room.getNumber(), LocalDate.now(), maxDate);

                    return AvailabeBookingDatesResponse.builder()
                            .roomNumber(room.getNumber())
                            .availabeDates(
                                    filterAvailabesDates(dates, bookinkgs)
                            )
                            .build();
                }
        )
                .filter(ret -> !ret.getAvailabeDates().isEmpty())
                .collect(Collectors.toList());


    }

    private List<String> filterAvailabesDates(Set<LocalDate> dates, List<Booking> bookinkgs) {
        return dates.stream().filter(
                date -> bookinkgs.stream().map(
                        booking ->
                                booking.getCheckInDate().isAfter(date) || booking.getCheckOutDate().isBefore(date)
                ).reduce(Boolean::equals).orElse(true)
        ).map(
                date -> date.format(DateTimeFormatter.ISO_DATE)
        ).collect(Collectors.toList());
    }


}
