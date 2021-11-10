package com.alten.hotelbooking.resources.request;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReSecheduleBookingRequest implements Serializable {

    private UUID id;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;

}
