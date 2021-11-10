package com.alten.hotelbooking.persistence.repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.alten.hotelbooking.persistence.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BookingRepository extends JpaRepository<Booking, UUID> {


    @Query("UPDATE Booking b SET b.status = com.alten.hotelbooking.enumerations.EnumBookingStatus.CANCELED WHERE b.id = :id")
    void cancelBooking(@Param("id")UUID bookingId);

    @Query(" FROM Booking b \n" +
            " INNER JOIN b.room r \n" +
            " WHERE r.number = :numberRoom \n" +
            " AND (:checkIn BETWEEN b.checkInDate AND b.checkOutDate OR :checkOut BETWEEN b.checkInDate AND b.checkOutDate) \n" +
            " AND b.status = com.alten.hotelbooking.enumerations.EnumBookingStatus.VALID")
    List<Booking> findShockingDatesDyRoomNumber(
            @Param("numberRoom") Integer numberRoom,
            @Param("checkIn") LocalDate checkIn,
            @Param("checkOut") LocalDate checkOut);


    @Query("FROM Booking b \n" +
            " INNER JOIN b.room r \n" +
            " WHERE r.number = :numberRoom \n" +
            " AND b.checkInDate BETWEEN :minDate \n" +
            " AND :maxDate \n" +
            " AND b.status = com.alten.hotelbooking.enumerations.EnumBookingStatus.VALID")
    List<Booking> findByNumberRoomAndInterval(
            @Param("numberRoom") Integer numberRoom,
            @Param("minDate") LocalDate minDate,
            @Param("maxDate") LocalDate maxDate
    );

    @Query(" FROM Booking b \n" +
            " INNER JOIN b.room r \n" +
            " WHERE r.number = :numberRoom \n" +
            " AND (b.checkInDate BETWEEN :minCheckIn AND :maxCheckIn)" )
    List<Booking> findByRoomNumberMinCheckInAndMaxChein(
            @Param("numberRoom") Integer numberRoom,
            @Param("minCheckIn") LocalDate minCheckIn,
            @Param("maxCheckIn") LocalDate maxCheckIn);


}
