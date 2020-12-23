package com.webmany.webapp;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class MainDate {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        Date date = new Date();
        System.out.println(date);
        System.out.println(date.getTime());
        System.out.println("----------------------------------------");

        LocalTime localTime = LocalTime.now();
        System.out.println(localTime);
        System.out.println("----------------------------------------");

        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);
        System.out.println("----------------------------------------");

        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);
        LocalDateTime localDateTime1 = LocalDateTime.of(localDate, localTime);
        System.out.println(localDateTime1);
        System.out.println("----------------------------------------");

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yy");
        System.out.println(simpleDateFormat.format(date));
        System.out.println("----------------------------------------");

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yy");
        String may = dateTimeFormatter.format(localDateTime);
        System.out.println(may + " dateTimeFormatter");
        System.out.println("----------------------------------------");

        // Clock clock = Clock.system();

        System.out.println(start + " <-- EPOCH");

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeZone(TimeZone.getTimeZone("America/Los_Angeles"));

        System.out.println(calendar.getTime());

        System.out.println(System.currentTimeMillis() - start);
    }
}
