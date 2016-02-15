package com.cricket.stats.appium;

import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mmadhusoodan on 4/6/15.
 */
public class DeviceConfiguration {
    final private static Logger log = Logger.getLogger(DeviceConfiguration.class);
    CommandPrompt cmd = new CommandPrompt();
    Map<String, String> devices = new HashMap<String, String>();

    /**
     * This method start adb server
     */
    public void startADB() throws Exception {
        String output = cmd.runCommand("adb start-server");
        String[] lines = output.split("\n");
        if (lines.length == 1)
            log.info("adb service already started");
        else if (lines[1].equalsIgnoreCase("* daemon started successfully *"))
            log.info("adb service started");
        else if (lines[0].contains("internal or external command")) {
            log.info("adb path not set in system varibale");
            System.exit(0);
        }
    }

    /**
     * This method stop adb server
     */
    public void stopADB() throws Exception {
        cmd.runCommand("adb kill-server");
    }

    /**
     * This method return connected devices
     *
     * @return hashmap of connected devices information
     */
    public Map<String, String> getDevices() throws Exception {

        try {
            startADB(); // start adb service
            String output = cmd.runCommand("adb devices");
            String[] lines = output.split("\n");

            if (lines.length <= 1) {
                log.info("No Device Connected");
                stopADB();
                System.exit(0);    // exit if no connected devices found
            }

            for (int i = 1; i < lines.length; i++) {
                lines[i] = lines[i].replaceAll("\\s+", "");

                if (lines[i].contains("device")) {
                    lines[i] = lines[i].replaceAll("device", "");
                    String deviceID = lines[i];
                    String model = cmd.runCommand("adb -s " + deviceID + " shell getprop ro.product.model").replaceAll("\\s+", "");
                    String brand = cmd.runCommand("adb -s " + deviceID + " shell getprop ro.product.brand").replaceAll("\\s+", "");
                    String osVersion = cmd.runCommand("adb -s " + deviceID + " shell getprop ro.build.version.release").replaceAll("\\s+", "");
                    String deviceName = brand + " " + model;

                    devices.put("deviceID" + i, deviceID);
                    devices.put("deviceName" + i, deviceName);
                    devices.put("osVersion" + i, osVersion);

                    log.info("Following device is connected");
                    log.info(deviceID + " " + deviceName + " " + osVersion + "\n");
                } else if (lines[i].contains("unauthorized")) {
                    lines[i] = lines[i].replaceAll("unauthorized", "");
                    String deviceID = lines[i];

                    log.info("Following device is unauthorized");
                    log.info(deviceID + "\n");
                } else if (lines[i].contains("offline")) {
                    lines[i] = lines[i].replaceAll("offline", "");
                    String deviceID = lines[i];

                    log.info("Following device is offline");
                    log.info(deviceID + "\n");
                }
            }
            return devices;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) throws Exception {
        DeviceConfiguration gd = new DeviceConfiguration();
        gd.startADB();
        gd.getDevices();
        gd.stopADB();
    }

}
