package com.aurel.lms.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConverter {

    private static final SimpleDateFormat formatter1=new SimpleDateFormat("dd/MM/yyyy");
    private static final SimpleDateFormat formatter2=new SimpleDateFormat("dd-MMM-yyyy");
    private static final SimpleDateFormat formatter3=new SimpleDateFormat("MM dd, yyyy");
    private static final SimpleDateFormat formatter4=new SimpleDateFormat("E, MMM dd yyyy");
    private static final SimpleDateFormat formatter5=new SimpleDateFormat("E, MMM dd yyyy HH:mm:ss");
    private static final SimpleDateFormat formatter6=new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");

    public static Date format1ToDate(String springDate) {
        try {
            return formatter1.parse(springDate);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String dateToFormat1(Date date) {
        return formatter1.format(date);
    }
}
