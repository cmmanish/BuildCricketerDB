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
    public void testGoogleSearch() {

        try {// Optional, if not specified, WebDriver will search your path for chromedriver.
            System.setProperty("webdriver.chrome.driver", QaConstants.MAC_CHROME_DRIVER_LOCATION);

            WebDriver driver = new SafariDriver();
            //WebDriver driver = new RemoteWebDriver("http://127.0.0.1:9515", DesiredCapabilities.safari());
            driver.get("http://www.google.com/xhtml");
            Thread.sleep(5000);  // Let the user actually see something!
            WebElement searchBox = driver.findElement(By.name("q"));
            searchBox.sendKeys("ChromeDriver");
            searchBox.submit();
            Thread.sleep(5000);  // Let the user actually see something!
            driver.quit();
        } catch (Exception e) {
            e.getMessage();
        }
    }


    @Test
    public void T1testPlayerMV() {

        cbURL = "http://www.cricbuzz.com/profiles/1597/";
        getBattingStats(cbURL);
    }

    @Test
    public void T2testPlayerSD() {

        cbURL = "http://www.cricbuzz.com/profiles/1446/";
        getBattingStats(cbURL);
    }

    @Test
    public void T3testPlayerLR() {

        cbURL = "http://www.cricbuzz.com/profiles/8733/";
        getBattingStats(cbURL);
    }

    @Test
    public void T4testPlayerCP() {

        cbURL = "http://www.cricbuzz.com/profiles/1448/";
        getBattingStats(cbURL);
    }

    @Test
    public void T5testPlayerVK() {

        cbURL = "http://www.cricbuzz.com/profiles/1413/";
        getBattingStats(cbURL);
    }

    @Test
    public void T6testPlayerAR() {

        cbURL = "http://www.cricbuzz.com/profiles/1447/";
        getBattingStats(cbURL);
    }

    @Test
    public void T7testPlayerSB() {

        cbURL = "http://www.cricbuzz.com/profiles/1530/";
        getBattingStats(cbURL);
    }

    @Test
    public void T8testPlayerRS() {

        cbURL = "http://www.cricbuzz.com/profiles/576/";
        getBattingStats(cbURL);
    }

    @Test
    public void T9testPlayerIS() {

        cbURL = "http://www.cricbuzz.com/profiles/702/";
        getBattingStats(cbURL);
    }

    @Test
    public void T10testPlayerMS() {

        cbURL = "http://www.cricbuzz.com/profiles/7909/";
        getBattingStats(cbURL);
    }

    @Test
    public void T11testPlayerBK() {

        cbURL = "http://www.cricbuzz.com/profiles/1726/";
        getBattingStats(cbURL);
    }

    @Test
    public void T12testPlayerUY() {

        cbURL = "http://www.cricbuzz.com/profiles/1858/";
        getBattingStats(cbURL);
    }

    @Test
    public void T13testPlayerRA() {

        cbURL = "http://www.cricbuzz.com/profiles/1593/";
        getBattingStats(cbURL);
    }

    @Test
    public void T14testPlayerAM() {

        cbURL = "http://www.cricbuzz.com/profiles/1454/";
        getBattingStats(cbURL);
    }

    @Test
    public void T15testPlayerWS() {

        cbURL = "http://www.cricbuzz.com/profiles/1465/";
        getBattingStats(cbURL);
    }
}