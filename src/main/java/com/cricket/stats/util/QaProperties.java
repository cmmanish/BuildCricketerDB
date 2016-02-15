package com.cricket.stats.util;

import org.apache.log4j.Logger;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class QaProperties { // singleton
    private static Logger log = Logger.getLogger(QaProperties.class);
    private static QaProperties instance;

    public static Properties props = getProperty();


    private QaProperties() {
    }

    public static QaProperties getInstance() {
        if (instance == null) {
            instance = new QaProperties();
        }
        return instance;
    }

    public static Properties getProperty() {
        Properties props = new Properties();
        try {
            FileInputStream in;
            String address = "src/main/resources/local.properties";

            log.info("Looking for property file: " + address);

            File fileProps = new File(address);

            if (fileProps.exists()) {
                in = new FileInputStream(fileProps);
            } else {
                in = new FileInputStream(new File("local.properties"));
            }

            props.load(in);
            in.close();
            return props;
        } catch (Exception e) {
            log.info(e);
            System.exit(1);
        }
        return props;
    }

    public  static Boolean getBrowserStack() throws NullPointerException {
        if (props.getProperty("portal.browserstack") == null) {
            return false;
        } else {
            return true;
        }
    }
    public static String getDeviceType() throws NullPointerException {
        if (props.getProperty("device") == null) {
            return "desktop";
        } else {
            return props.getProperty("device").trim().toString();
        }
    }

    public static String getBrowser() throws NullPointerException {
        if (props.getProperty("portal.browser") == null) {
            return "firefox";
        } else {
            return props.getProperty("portal.browser").trim();
        }
    }

    public static String getLyveSuiteURL() throws NullPointerException {
        return props.getProperty("portal.url").trim();
    }

    public static String getPortalURL() throws NullPointerException {
        return props.getProperty("portal.url").trim();
    }

    public static String getStack() throws NullPointerException {
        String stack = "dogfood";
        String url = props.getProperty("portal.url").trim();
        if (!"".equalsIgnoreCase(url)) {
            url = url.split(".blackpearlsystems.net")[0];
            stack = url.split("https://lyvesuite.")[1];
        }
        return stack;
    }

    public static String getScreenShotsDir() throws NullPointerException {
        return props.getProperty("screenshots.root.folder").trim();
    }

    public static String getReportsDir() throws NullPointerException {
        return props.getProperty("reports.root.folder").trim();
    }

    public static String getTestRailsReportDir() throws NullPointerException {
        return props.getProperty("testrail_scripts.root.folder").trim();
    }

    public static boolean isBrowserStack() {

        return "true".equalsIgnoreCase(props.getProperty("browserStack"));
    }

    public static boolean isFirefox() {
        return "firefox".equals(getBrowser());
    }

    public static boolean isChrome() {
        return "chrome".equals(getBrowser());
    }

    public static boolean isIE() {
        return "ie".equals(getBrowser());
    }

    public static boolean isSafari() { return "safari".equals(getBrowser()); }

//    public static boolean isSafari() {
//        return "safari".equals(getBrowser());
//    }

    public static boolean isAndroidChrome() {
        return "AndroidChrome".equals(getBrowser());
    }

}