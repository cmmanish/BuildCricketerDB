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
            String address = "src/upload/resources/local.properties";
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
            e.printStackTrace();
            System.exit(1);
        }
        return props;
    }
}