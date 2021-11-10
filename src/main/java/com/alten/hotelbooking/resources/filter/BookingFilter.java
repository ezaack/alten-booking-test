package com.alten.hotelbooking.resources.filter;

import java.time.LocalDate;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BookingFilter {
    private Integer roomNumber;
    private LocalDate minCheckIn;
    private LocalDate maxCheckIn;
}
