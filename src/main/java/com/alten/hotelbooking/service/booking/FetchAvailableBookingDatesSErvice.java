package com.alten.hotelbooking.service.booking;

import java.util.List;

import com.alten.hotelbooking.resources.response.AvailabeBookingDatesResponse;

public interface FetchAvailableBookingDatesSErvice {

    List<AvailabeBookingDatesResponse> fetch();
}
