package com.alten.hotelbooking.helper;

import java.time.LocalDate;
import java.util.Set;

import org.springframework.cache.annotation.Caching;

public final class CreateAListOfDatesHelper {
    private CreateAListOfDatesHelper() {
    }

    @Caching
    public static void getNextDays(LocalDate date, LocalDate maxDate, Set<LocalDate> dates) {
        if (date.isBefore(maxDate)) {
            LocalDate nextDate = date.plusDays(1L);
            dates.add(nextDate);
            getNextDays(nextDate, maxDate, dates);
        }
    }
}
