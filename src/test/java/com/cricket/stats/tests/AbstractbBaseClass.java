package com.cricket.stats.tests;

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

import static com.cricket.stats.utils.QaConstants.MAC_CHROME_DRIVER_LOCATION;
import static com.cricket.stats.utils.QaConstants.PLAYER_JSON_LOCATION;

/**
 * Created by mmadhusoodan on 8/20/15.
 */
public class AbstractbBaseClass {

    public static Logger log = Logger.getLogger(String.valueOf(AbstractbBaseClass.class));
    protected String baseURL = "http://www.cricbuzz.com/";
    protected static JSONObject playerStatsJSON = new org.json.simple.JSONObject();
    protected JSONObject eachPlayer = new JSONObject();
    protected static JSONArray resultsList = new JSONArray();
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
        filePath = PLAYER_JSON_LOCATION + File.separator + fileName;
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
            System.setProperty("webdriver.chrome.driver", MAC_CHROME_DRIVER_LOCATION);
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
            eachPlayer.put("cricbuzzId", id);
            eachPlayer.put("country", country);
            eachPlayer.put("playerName", name);
            eachPlayer.put("tests", tests);
            eachPlayer.put("innings", inns);
            eachPlayer.put("runs", runs);
            eachPlayer.put("batAvg", batAvg);
            eachPlayer.put("strikeRate", strikeRate);
            eachPlayer.put("highestScore", highestScore);
            eachPlayer.put("notOuts", notOuts);
            eachPlayer.put("hundreds", hundreds);
            eachPlayer.put("fifties", fifties);
            eachPlayer.put("sixes", sixes);
            eachPlayer.put("fours", fours);
            resultsList.add(eachPlayer);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void extractBattingStats(String cbURL) {
        try {
            //driver.navigate().to(CRICBUZZ_BASE_URL);
            driver.navigate().to(cbURL);
            id = cbURL.substring(33, cbURL.length() - 1);
            name = driver.findElement(By.cssSelector(".cb-font-40")).getText();
            tests = driver.findElement(By.cssSelector(".cb-plyr-tbody.text-right")).getText();

            List<WebElement> battingStats = driver.findElements(By.cssSelector(".text-right"));
            inns = battingStats.get(23).getText();
            notOuts = battingStats.get(24).getText();
            runs = battingStats.get(25).getText();
            highestScore = battingStats.get(26).getText();
            batAvg = battingStats.get(27).getText();
            strikeRate = battingStats.get(29).getText();

            hundreds = battingStats.get(30).getText();
            fifties = battingStats.get(32).getText();

            fours = battingStats.get(33).getText();
            sixes = battingStats.get(34).getText();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}