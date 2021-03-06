package com.cricket.stats.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.LogManager;
import java.util.logging.Logger;

/**
 * Created by mmadhusoodan on 11/24/14.
 */
public class QaCalendar {
    protected Logger log = LogManager.getLogManager().getLogger(String.valueOf(QaCalendar.class));

    private static SimpleDateFormat mmddyyyyyHHMMFormat = new SimpleDateFormat("MM-dd-yyyy-hh:mm");
    private static SimpleDateFormat hyphenDateFormat = new SimpleDateFormat("MM-dd-yyyy");
    private static SimpleDateFormat slashDateFormat = new SimpleDateFormat("MM/dd/yyyy");
    private static Calendar calendar = Calendar.getInstance();
    private static QaCalendar instance;

    private QaCalendar() {
    }

    public static synchronized QaCalendar getInstance() {

        if (instance == null) {
            instance = new QaCalendar();
        }

        return instance;
    }

    public String getCaptureTime() {

        final String captureDate = mmddyyyyyHHMMFormat.format(calendar.getTime());
        return captureDate;
    }

    public static String getHumanReadableDateFromEpoch(long epochSec) {
        Date date = new Date(epochSec);

        return mmddyyyyyHHMMFormat.format(date);
    }

    public static String getSlashDateFromHyphenDate(String hyphenDate) {

        try {
            Date frmDate = hyphenDateFormat.parse(hyphenDate); // Handle the ParseException here
            String slashDateStr = slashDateFormat.format(frmDate);
//            log.info(slashDateStr);
            return slashDateStr;

        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }


    }
}
