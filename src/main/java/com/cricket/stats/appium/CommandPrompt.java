package com.cricket.stats.appium;

import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by mmadhusoodan on 4/6/15.
 */
public class CommandPrompt {
    final private static Logger log = Logger.getLogger(CommandPrompt.class);

    Process p;
    ProcessBuilder builder;

    /**
     * This method run command on windows and mac
     *
     * @param command to run
     */
    public String runCommand(String command) throws InterruptedException, IOException {
        // build cmd proccess according to os

        try {
            String line = "";
            String allLine = "";
            p = Runtime.getRuntime().exec(command);

            // get std output
            BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));

            int i = 1;
            while ((line = r.readLine()) != null) {
                allLine = allLine + "" + line + "\n";
                if (line.contains("Console LogLevel: debug"))
                    break;
                i++;
            }
            return allLine;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public static void main(String[] args) throws Exception {
        CommandPrompt cmd = new CommandPrompt();
        log.info(cmd.runCommand("adb devices"));
    }
}
