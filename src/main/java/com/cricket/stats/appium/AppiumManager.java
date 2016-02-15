package com.cricket.stats.appium;

import org.apache.log4j.Logger;

/**
 * Created by mmadhusoodan on 4/6/15.
 */
public class AppiumManager {
    private static Process process;

    final private static Logger log = Logger.getLogger(AppiumManager.class);
    private CommandPrompt cp = new CommandPrompt();
    private AvailabelPorts ap = new AvailabelPorts();

    /**
     * start appium with default arguments
     */
    public void startDefaultAppium() throws Exception {
        cp.runCommand("appium --session-override");
        Thread.sleep(5000);
    }

    /**
     * start appium with auto generated ports : appium port, chrome port, and bootstap port
     */
    public String startAppium() {
        // start appium server
        try {
            String port = ap.getPort();
            String chromePort = ap.getPort();
            String bootstrapPort = ap.getPort();

            String command = "appium --address 0.0.0.0 -p " + port + " --chromedriver-port " + chromePort + " -bp " + bootstrapPort;
            log.info(command);
            String output = cp.runCommand(command);
            log.info(output);

            if (output.contains("not")) {
                log.info("\nAppium is not installed");
                System.exit(0);
            } else if (output.contains("Requested port is already in use")) {
                log.info(output);
            }
            return port;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public void startAppiumServer(String port, String chromePort, String bootstrapPort) throws Exception {
        try {
            String command = "appium --address 0.0.0.0 -p " + port + " --chromedriver-port " + chromePort + " -bp " + bootstrapPort;
            log.info(command);
            String output = cp.runCommand(command);
            log.info(output);

            if (output.contains("not")) {
                log.info("\nAppium is not installed");
                System.exit(0);
            } else if (output.contains("Requested port is already in use")) {
                log.info(output);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        AppiumManager appiumManager = new AppiumManager();
        appiumManager.startAppium();

    }
}
