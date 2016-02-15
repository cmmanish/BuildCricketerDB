package com.cricket.stats.tests;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

/**
 * Created by mmadhusoodan on 1/13/2015.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestPopulateSouthAfricaPlayers extends AbstractbBaseClass {

    static String country = "SA";
    static String fileName = country +"PlayerStats.json";

    public TestPopulateSouthAfricaPlayers() {
        super(TestPopulateSouthAfricaPlayers.fileName, TestPopulateSouthAfricaPlayers.country);
    }

    @Test
    public void T1testPlayerMV() {

        cbURL = "http://www.cricbuzz.com/profiles/2288/";
        getBattingStats(cbURL);
    }

    @Test
    public void T2testPlayerSD() {

        cbURL = "http://www.cricbuzz.com/profiles/2239/";
        getBattingStats(cbURL);
    }

    @Test
    public void T3testPlayerLR() {

        cbURL = "http://www.cricbuzz.com/profiles/314/";
        getBattingStats(cbURL);
    }

    @Test
    public void T4testPlayerCP() {

        cbURL = "http://www.cricbuzz.com/profiles/7825/";
        getBattingStats(cbURL);
    }

    @Test
    public void T5testPlayerVK() {

        cbURL = "http://www.cricbuzz.com/profiles/8583/";
        getBattingStats(cbURL);
    }

    @Test
    public void T6testPlayerAR() {

        cbURL = "http://www.cricbuzz.com/profiles/731/";
        getBattingStats(cbURL);
    }

    @Test
    public void T7testPlayerSB() {

        cbURL = "http://www.cricbuzz.com/profiles/508/";
        getBattingStats(cbURL);
    }

    @Test
    public void T8testPlayerRS() {

        cbURL = "http://www.cricbuzz.com/profiles/9540/";
        getBattingStats(cbURL);
    }

    @Test
    public void T9testPlayerIS() {

        cbURL = "http://www.cricbuzz.com/profiles/608/";
        getBattingStats(cbURL);
    }

    @Test
    public void T10testPlayerIS() {

        cbURL = "http://www.cricbuzz.com/profiles/8099/";
        getBattingStats(cbURL);
    }

    @Test
    public void T11testPlayerBK() {

        cbURL = "http://www.cricbuzz.com/profiles/370/";
        getBattingStats(cbURL);
    }

    @Test
    public void T12testPlayerBK() {

        cbURL = "http://www.cricbuzz.com/profiles/585/";
        getBattingStats(cbURL);
    }

    @Test
    public void T13testPlayerBK() {

        cbURL = "http://www.cricbuzz.com/profiles/9585/";
        getBattingStats(cbURL);
    }

    @Test
    public void T14testPlayerBK() {

        cbURL = "http://www.cricbuzz.com/profiles/318/";
        getBattingStats(cbURL);
    }

    @Test
    public void T15testPlayerBK() {

        cbURL = "http://www.cricbuzz.com/profiles/8520/";
        getBattingStats(cbURL);
    }
}