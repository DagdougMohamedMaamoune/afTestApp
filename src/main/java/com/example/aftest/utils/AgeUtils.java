package com.example.aftest.utils;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

public class AgeUtils {
    public static int calculateAge(Date birthDate, Date currDate) {
        LocalDate localDateBd = birthDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate localDateCd = currDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        return Period.between(localDateBd, localDateCd).getYears();
    }
}
