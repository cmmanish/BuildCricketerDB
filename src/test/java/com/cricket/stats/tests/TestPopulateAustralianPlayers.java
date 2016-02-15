package com.cricket.stats.tests;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

/**
 * Created by mmadhusoodan on 1/13/2015.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestPopulateAustralianPlayers extends AbstractbBaseClass {

    static String country = "AUS";
    static String fileName = country +"PlayerStats.json";

    public TestPopulateAustralianPlayers() {
        super(TestPopulateAustralianPlayers.fileName, TestPopulateAustralianPlayers.country);
    }

    @Test
    public void T1testPlayerMV() {

        cbURL = "http://www.cricbuzz.com/profiles/1042/";
        getBattingStats(cbURL);
    }

    @Test
    public void T2testPlayerSD() {

        cbURL = "http://www.cricbuzz.com/profiles/1739/";
        getBattingStats(cbURL);
    }

    @Test
    public void T3testPlayerLR() {

        cbURL = "http://www.cricbuzz.com/profiles/2250/";
        getBattingStats(cbURL);
    }

    @Test
    public void T4testPlayerCP() {

        cbURL = "http://www.cricbuzz.com/profiles/138/";
        getBattingStats(cbURL);
    }

    @Test
    public void T5testPlayerVK() {

        cbURL = "http://www.cricbuzz.com/profiles/605/";
        getBattingStats(cbURL);
    }

    @Test
    public void T6testPlayerAR() {

        cbURL = "http://www.cricbuzz.com/profiles/6250/";
        getBattingStats(cbURL);
    }

    @Test
    public void T7testPlayerSB() {

        cbURL = "http://www.cricbuzz.com/profiles/7738/";
        getBattingStats(cbURL);
    }

    @Test
    public void T8testPlayerRS() {

        cbURL = "http://www.cricbuzz.com/profiles/496/";
        getBattingStats(cbURL);
    }

    @Test
    public void T9testPlayerIS() {

        cbURL = "http://www.cricbuzz.com/profiles/7710/";
        getBattingStats(cbURL);
    }

    @Test
    public void T10testPlayerMS() {

        cbURL = "http://www.cricbuzz.com/profiles/1444/";
        getBattingStats(cbURL);
    }

    @Test
    public void T11testPlayerMS() {

        cbURL = "http://www.cricbuzz.com/profiles/7850/";
        getBattingStats(cbURL);
    }

    @Test
    public void T12testPlayerMS() {

        cbURL = "http://www.cricbuzz.com/profiles/8095/";
        getBattingStats(cbURL);
    }
    @Test
    public void T13testPlayerMS() {

        cbURL = "http://www.cricbuzz.com/profiles/8969/";
        getBattingStats(cbURL);
    }
    @Test
    public void T14testPlayerMS() {

        cbURL = "http://www.cricbuzz.com/profiles/158/";
        getBattingStats(cbURL);
    }

    @Test
    public void T15testPlayerMS() {

        cbURL = "http://www.cricbuzz.com/profiles/563/";
        getBattingStats(cbURL);
    }

}