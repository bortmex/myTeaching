package com.rog.teach.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {
    private static final DateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");

    public static String getStrDate(Date date) {
        return DATE_FORMAT.format(date);
    }
}
