package com.cricket.stats.util;

import org.apache.log4j.Logger;

/**
 * Created by mmadhusoodan on 3/20/15.
 */
public class QaConvertor {

    final private static Logger log = Logger.getLogger(QaConvertor.class);

    public static String MetricToInteger(String metricNumber) {

        metricNumber = metricNumber.trim();
        Integer integer = Integer.parseInt(metricNumber.replace(",", ""));
        return integer.toString();
    }

    public static String IntegerToMetric(String integer) {

        integer = integer.trim();
        Integer metricNumber = Integer.parseInt(integer.replace(",", ""));
        return metricNumber.toString();
    }

    public static String IntegerToM(String integer) {

        integer = integer.trim();
        Integer metricNumber = Integer.parseInt(integer.replace(",", ""));
        return metricNumber.toString();
    }

}
