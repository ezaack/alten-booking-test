package com.alten.hotelbooking.resources.response;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BookingResponse implements Serializable {

    private UUID id;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate checkInDate;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate checkOutDate;
    @JsonFormat(pattern = "yyyy-MM-dd hh:MM:ss")
    private ZonedDateTime bookingDateTime;
    private List<GestResponse> gests;
    private Integer roomNumber;
}
