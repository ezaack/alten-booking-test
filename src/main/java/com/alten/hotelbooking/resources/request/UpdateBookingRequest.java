package com.alten.hotelbooking.resources.request;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class UpdateBookingRequest implements Serializable {

    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private List<GestRequest> gests;
    private Integer roomNumber;
    private UUID id;


}
