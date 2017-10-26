package com.epam.androidlab.instagramclient.utils;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TimeConverter {
    private String dateFormat = "yyyy-MM-dd";

    public String getCurrentTime() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat date = new SimpleDateFormat(dateFormat);
        return date.format(calendar.getTime());
    }

    public String convertToUnixTime(String time) {
        //since 6.10.2010
        Date d = new Date();
        try {
            d = new SimpleDateFormat(dateFormat).parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String date = String.valueOf(d.getTime() / 1000);
        return date;
    }

    public void convertToGregorianCalendar(String time) {

    }
}
