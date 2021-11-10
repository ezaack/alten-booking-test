package com.alten.hotelbooking.persistence.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.alten.hotelbooking.enumerations.EnumBookingStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_booking")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Booking implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "checkin_date", nullable = false)
    private LocalDate checkInDate;
    @Column(name = "checkout_date", nullable = false)
    private LocalDate checkOutDate;
    @Column(name = "booking_date_time", nullable = false)
    private ZonedDateTime bookingDateTime;
    @OneToMany(mappedBy = "booking", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Gest> gests;
    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private EnumBookingStatus status;

    public List<Gest> getGests() {
        if (gests == null) {
            gests = new ArrayList<>();
        }
        return gests;
    }
}
