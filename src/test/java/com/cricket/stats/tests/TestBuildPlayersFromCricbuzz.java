package com.cricket.stats.tests;

import org.apache.commons.lang3.time.DurationFormatUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.logging.Logger;

import service.TestDatabaseOperationsV2;

import static com.cricket.stats.utils.QaConstants.CRICBUZZ_PROFILE_BASE_URL;
import static com.cricket.stats.utils.QaConstants.PLAYER_JSON_LOCATION;

/**
 * Created by mmadhusoodan on 6/4/15.
 */
public class TestBuildPlayersFromCricbuzz extends AbstractbBaseClass {

    public static Logger log = Logger.getLogger(String.valueOf(TestBuildPlayersFromCricbuzz.class));

    static String country = "XXX";
    static String fileName = country + "PlayerStats.json";
    static JSONArray resultsList = new JSONArray();
    static long time;

    public TestBuildPlayersFromCricbuzz() {
        time = System.currentTimeMillis();
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

    public JSONObject extractBattingStatsIntoJson(String cbURL) {
        JSONObject playerInfoJson = new JSONObject();
        try {
            driver.navigate().to(cbURL);
            id = cbURL.substring(33, cbURL.length() - 1);
            name = driver.findElement(By.cssSelector(".cb-font-40")).getText();
            country = driver.findElement(By.cssSelector(".cb-font-18.text-gray")).getText();
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

            playerInfoJson.put("cricbuzzId", id);
            playerInfoJson.put("country", country);
            playerInfoJson.put("playerName", name);
            playerInfoJson.put("tests", tests);
            playerInfoJson.put("innings", inns);
            playerInfoJson.put("runs", runs);
            playerInfoJson.put("batAvg", batAvg);
            playerInfoJson.put("strikeRate", strikeRate);
            playerInfoJson.put("highestScore", highestScore);
            playerInfoJson.put("notOuts", notOuts);
            playerInfoJson.put("hundreds", hundreds);
            playerInfoJson.put("fifties", fifties);
            playerInfoJson.put("sixes", sixes);
            playerInfoJson.put("fours", fours);
        } catch (Exception e) {
            //log.warning(e.getMessage());
        }
        return playerInfoJson;
    }

    Instant start, end;
    @Before
    public void beforeTest(){
        start = Instant.now();
    }

    @After
    public void afterTest(){
        end = Instant.now();
        Duration timeElapsed = Duration.between(start, end);
        log.info("Time taken: "+ timeElapsed.toMillis() +" milliseconds");
    }

    @Test
    public void T1testPlayer() {

        for (int i = 25; i < 999; i++) {
            cbURL = CRICBUZZ_PROFILE_BASE_URL + i + "/";
            try {
                JSONObject playerInfoJson = extractBattingStatsIntoJson(cbURL);
                if (playerInfoJson.size()!=0)
                    resultsList.add(playerInfoJson);
            } catch (Exception e) {
                //log.warning(e.getMessage());
            }
        }
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
        long completedIn = System.currentTimeMillis() - time;
        DurationFormatUtils.formatDuration(completedIn, "HH:mm:ss:SS");
    }
}