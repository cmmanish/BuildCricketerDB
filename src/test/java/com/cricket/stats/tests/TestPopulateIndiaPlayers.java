package com.cricket.stats.tests;

import com.cricket.stats.utils.QaConstants;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import static com.cricket.stats.utils.QaConstants.CRICBUZZ_PROFILE_BASE_URL;

/**
 * Created by mmadhusoodan on 1/13/2015.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestPopulateIndiaPlayers extends AbstractbBaseClass {

    static String country = "IND";
    static String fileName = country + "PlayerStats.json";

    public TestPopulateIndiaPlayers() {
        super(TestPopulateIndiaPlayers.fileName, TestPopulateIndiaPlayers.country);
    }

    @Test
    public void T1testPlayerMV() {

        cbURL = CRICBUZZ_PROFILE_BASE_URL+"1597/";
        getBattingStats(cbURL);
    }

    @Test
    public void T2testPlayerSD() {

        cbURL = CRICBUZZ_PROFILE_BASE_URL+"1446/";
        getBattingStats(cbURL);
    }

    @Test
    public void T3testPlayerLR() {

        cbURL = CRICBUZZ_PROFILE_BASE_URL+"8733/";
        getBattingStats(cbURL);
    }

    @Test
    public void T4testPlayerCP() {

        cbURL = CRICBUZZ_PROFILE_BASE_URL+"1448/";
        getBattingStats(cbURL);
    }

    @Test
    public void T5testPlayerVK() {

        cbURL = CRICBUZZ_PROFILE_BASE_URL+"1413/";
        getBattingStats(cbURL);
    }

    @Test
    public void T6testPlayerAR() {

        cbURL = CRICBUZZ_PROFILE_BASE_URL+"1447/";
        getBattingStats(cbURL);
    }

    @Test
    public void T7testPlayerSB() {

        cbURL = CRICBUZZ_PROFILE_BASE_URL+"1530/";
        getBattingStats(cbURL);
    }

    @Test
    public void T8testPlayerRS() {

        cbURL = CRICBUZZ_PROFILE_BASE_URL+"576/";
        getBattingStats(cbURL);
    }

    @Test
    public void T9testPlayerIS() {

        cbURL = CRICBUZZ_PROFILE_BASE_URL+"702/";
        getBattingStats(cbURL);
    }

    @Test
    public void T10testPlayerMS() {

        cbURL = CRICBUZZ_PROFILE_BASE_URL+"7909/";
        getBattingStats(cbURL);
    }

    @Test
    public void T11testPlayerBK() {

        cbURL = CRICBUZZ_PROFILE_BASE_URL+"1726/";
        getBattingStats(cbURL);
    }

    @Test
    public void T12testPlayerUY() {

        cbURL = CRICBUZZ_PROFILE_BASE_URL+"1858/";
        getBattingStats(cbURL);
    }

    @Test
    public void T13testPlayerRA() {

        cbURL = CRICBUZZ_PROFILE_BASE_URL+"1593/";
        getBattingStats(cbURL);
    }

    @Test
    public void T14testPlayerAM() {

        cbURL = CRICBUZZ_PROFILE_BASE_URL+"1454/";
        getBattingStats(cbURL);
    }

    @Test
    public void T15testPlayerWS() {

        cbURL = CRICBUZZ_PROFILE_BASE_URL+"1465/";
        getBattingStats(cbURL);
    }
}