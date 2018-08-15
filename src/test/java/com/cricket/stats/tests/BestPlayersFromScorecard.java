package com.cricket.stats.tests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.logging.Logger;

/**
 * Created by mmadhusoodan on 6/4/15.
 */
public class BestPlayersFromScorecard extends AbstractbBaseClass {

    public static Logger log = Logger.getLogger(String.valueOf(BestPlayersFromScorecard.class));

    private String baseURL = "http://www.cricbuzz.com/";
    private String name, mat, inns, runs, hs, avg, sr = "";

    @Test
    public void testPlayerMV() {

        String match = "http://www.cricbuzz.com/live-cricket-scorecard/14875/";
        getPlaying11(match);
    }

    public void getPlaying11(String match) {
        try {
//            driver.navigate().to(baseURL);
//            driver.navigate().to(match);
//            List<WebElement> battingStats = driver.findElements(By.cssSelector(".fixedwidth .pName1 .left"));
//            log.info(battingStats.get(0).getText());
//
//            driver.close();
        } catch (Exception ne) {
            ne.printStackTrace();
        }
    }

}
