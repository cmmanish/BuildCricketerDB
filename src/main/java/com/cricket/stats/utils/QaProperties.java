package com.cricket.stats.utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.logging.Logger;

public class QaProperties { // singleton
    public static Logger log = Logger.getLogger(String.valueOf(QaProperties.class));
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
//            log.info("Looking for property file: " + address);
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
            e.printStackTrace();
            System.exit(1);
        }
        return props;
    }

    public static String getBrowser() throws NullPointerException {
        if (props.getProperty("portal.browser") == null) {
            return "firefox";
        } else {
            return props.getProperty("portal.browser").trim();
        }
    }


    public static String getScreenShotsDir() throws NullPointerException {
        return props.getProperty("screenshots.root.folder").trim();
    }

    public static String getReportsDir() throws NullPointerException {
        return props.getProperty("reports.root.folder").trim();
    }

    public static String getJSONDir() throws NullPointerException {
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