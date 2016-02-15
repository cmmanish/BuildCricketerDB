package com.cricket.stats.tests;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

/**
 * Created by mmadhusoodan on 1/13/2015.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestPopulateWestIndiesPlayers extends AbstractbBaseClass {

    static String country = "WI";
    static String fileName = country +"PlayerStats.json";

    public TestPopulateWestIndiesPlayers() {
        super(TestPopulateWestIndiesPlayers.fileName, TestPopulateWestIndiesPlayers.country);
    }

    @Test
    public void T1testPlayerMV() {

        cbURL = "http://www.cricbuzz.com/profiles/247/";
        getBattingStats(cbURL);
    }

    @Test
    public void T2testPlayerSD() {

        cbURL = "http://www.cricbuzz.com/profiles/1984/";
        getBattingStats(cbURL);
    }

    @Test
    public void T3testPlayerLR() {

        cbURL = "http://www.cricbuzz.com/profiles/7748/";
        getBattingStats(cbURL);
    }

    @Test
    public void T4testPlayerCP() {

        cbURL = "http://www.cricbuzz.com/profiles/1610/";
        getBattingStats(cbURL);
    }

    @Test
    public void T5testPlayerVK() {

        cbURL = "http://www.cricbuzz.com/profiles/244/";
        getBattingStats(cbURL);
    }

    @Test
    public void T6testPlayerAR() {

        cbURL = "http://www.cricbuzz.com/profiles/9400/";
        getBattingStats(cbURL);
    }

    @Test
    public void T7testPlayerSB() {

        cbURL = "http://www.cricbuzz.com/profiles/399/";
        getBattingStats(cbURL);
    }

    @Test
    public void T8testPlayerRS() {

        cbURL = "http://www.cricbuzz.com/profiles/379/";
        getBattingStats(cbURL);
    }

    @Test
    public void T9testPlayerIS() {

        cbURL = "http://www.cricbuzz.com/profiles/1359/";
        getBattingStats(cbURL);
    }

    @Test
    public void T11testPlayerMS() {

        cbURL = "http://www.cricbuzz.com/profiles/1117/";
        getBattingStats(cbURL);
    }

    @Test
    public void T12testPlayerMS() {

        cbURL = "http://www.cricbuzz.com/profiles/8092/";
        getBattingStats(cbURL);
    }
    @Test
    public void T13testPlayerMS() {

        cbURL = "http://www.cricbuzz.com/profiles/6482/";
        getBattingStats(cbURL);
    }
    @Test
    public void T14testPlayerMS() {

        cbURL = "http://www.cricbuzz.com/profiles/8313/";
        getBattingStats(cbURL);
    }
    @Test
    public void T10testPlayerMS() {

        cbURL = "http://www.cricbuzz.com/profiles/242/";
        getBattingStats(cbURL);
    }
    @Test
    public void T15testPlayerMS() {

        cbURL = "http://www.cricbuzz.com/profiles/381/";
        getBattingStats(cbURL);
    }

}