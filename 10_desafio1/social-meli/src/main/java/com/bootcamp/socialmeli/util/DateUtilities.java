package com.bootcamp.socialmeli.util;

import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DateUtilities {

    public LocalDate getTwoWeeksAgo() {
        return LocalDate.now().minusWeeks(2);
    }
}
