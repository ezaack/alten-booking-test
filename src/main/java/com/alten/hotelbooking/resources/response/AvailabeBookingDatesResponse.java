package com.alten.hotelbooking.resources.response;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class AvailabeBookingDatesResponse {

    private Integer roomNumber;
    private List<String> availabeDates;
}
