package com.example.home;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CalendarHelper {

    Calendar calendar = Calendar.getInstance();

    public Integer getMonthNumber(String string) {
        try {
            calendar.setTime(new SimpleDateFormat("dd/MM/yyyy").parse(string));
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
        return calendar.get(Calendar.MONTH);
    }

    public Integer getYear(String string) {
        try {
            calendar.setTime(new SimpleDateFormat("dd/MM/yyyy").parse(string));
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
            return calendar.get(Calendar.YEAR);
    }


    public Integer getWeekNumber(String string) {
        try {
            calendar.setTime(new SimpleDateFormat("dd/MM/yyyy").parse(string));
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
            return calendar.get(Calendar.WEEK_OF_YEAR);
    }
}
