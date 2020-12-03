package com.webmany.webapp;

import java.util.Calendar;

public class MainDate {

    public static void main(String[] args) {
        long time = System.currentTimeMillis();
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar.getTime());
        System.out.println(System.currentTimeMillis() - time);
    }
}
