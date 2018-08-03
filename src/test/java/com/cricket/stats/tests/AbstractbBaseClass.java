package com.cricket.stats.tests;

import com.cricket.stats.utils.QaConstants;
import com.cricket.stats.utils.QaProperties;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by mmadhusoodan on 8/20/15.
 */
public class AbstractbBaseClass {

    public static Logger log = Logger.getLogger(String.valueOf(TestPopulateIndiaPlayers.class));
    protected String baseURL = "http://www.cricbuzz.com/";
    protected static JSONObject playerStatsJSON = new org.json.simple.JSONObject();
    protected JSONObject eachPlayer = new JSONObject();
    protected static JSONArray resultsList = new JSONArray();
    protected static String testrailDir = QaProperties.getJSONDir();
    protected String id = "", country = "", cbURL = "", name = "", tests = "0", inns = "0", fours = "0", sixes = "0";
    protected String runs = "0", highestScore = "0", batAvg = "0.00", strikeRate = "0.00", notOuts = "0", hundreds = "0", fifties = "0";
    protected static String fileName = "";
    protected static String filePath = "";
    protected static File file = null;
    protected static FileWriter fileWriter = null;
    protected static WebDriver driver = null;


    public AbstractbBaseClass() {
    }

    public AbstractbBaseClass(String fileName, String countryName) {
        country = countryName;
        filePath = testrailDir + File.separator + fileName;
        file = new File(filePath);
        try {
            if (!file.exists()) {
                log.info(fileName + " doesn't exist : So creating it at " + filePath);
                file.createNewFile();
                log.info(fileName + " filed created ");
            }
            fileWriter = new FileWriter(filePath);
            playerStatsJSON.put("Players", resultsList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static WebDriver getWebDriver() {
        try {
            System.setProperty("webdriver.chrome.driver", QaConstants.MAC_CHROME_DRIVER_LOCATION);
            driver = new ChromeDriver();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return driver;
    }

    @BeforeClass
    public static void testSetup() {
        driver = getWebDriver();
    }

    @AfterClass
    public static void testTearDown() {
        try {
            fileWriter.append(playerStatsJSON.toString());
            fileWriter.flush();
            fileWriter.close();
            driver.close();
            driver.quit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @After
    public void afterMethod() {

        try {
            eachPlayer.put("cbURL", cbURL);
            eachPlayer.put("country", country);
            eachPlayer.put("playerName", name);
            eachPlayer.put("highestScore", highestScore);
            eachPlayer.put("batAvg", batAvg);
            eachPlayer.put("strikeRate", strikeRate);
            eachPlayer.put("runs", runs);
            eachPlayer.put("innings", inns);
            eachPlayer.put("tests", tests);
            eachPlayer.put("notOuts", notOuts);
            eachPlayer.put("hundreds", hundreds);
            eachPlayer.put("fifties", fifties);
            eachPlayer.put("fours", fours);
            eachPlayer.put("sixes", sixes);
            eachPlayer.put("id", id);

            resultsList.add(eachPlayer);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getBattingStats(String cbURL) {
        try {
            driver.navigate().to(baseURL);
            driver.navigate().to(cbURL);
            id = cbURL.substring(33, cbURL.length() - 1);
//            name = driver.findElement(By.className("cb-profile-player-name")).getText();
            //WebElement element = driver.findElement(By.id("Tests_batting"));
            List<WebElement> battingStats = driver.findElements(By.cssSelector(".cb-stats-table .text-right"));

            tests = battingStats.get(0).getText();
            inns = battingStats.get(1).getText();
            notOuts = battingStats.get(2).getText();
            runs = battingStats.get(3).getText();
            highestScore = battingStats.get(4).getText();
            batAvg = battingStats.get(5).getText();
            strikeRate = battingStats.get(6).getText();

            hundreds = battingStats.get(8).getText();
            fifties = battingStats.get(10).getText();

            fours = battingStats.get(11).getText();
            sixes = battingStats.get(12).getText();

            return name;
        } catch (Exception ne) {
            ne.printStackTrace();
            return "";
        }
    }
}
