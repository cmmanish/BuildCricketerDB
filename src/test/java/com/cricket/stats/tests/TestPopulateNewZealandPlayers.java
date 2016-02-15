package com.cricket.stats.tests;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

/**
 * Created by mmadhusoodan on 1/13/2015.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestPopulateNewZealandPlayers extends AbstractbBaseClass {

    static String country = "NZ";
    static String fileName = country +"PlayerStats.json";

    public TestPopulateNewZealandPlayers() {
        super(TestPopulateNewZealandPlayers.fileName, TestPopulateNewZealandPlayers.country);
    }

    @Test
    public void T1testPlayerMV() {

        cbURL = "http://www.cricbuzz.com/profiles/1457/";
        getBattingStats(cbURL);
    }

    @Test
    public void T2testPlayerSD() {

        cbURL = "http://www.cricbuzz.com/profiles/8216/";
        getBattingStats(cbURL);
    }

    @Test
    public void T3testPlayerLR() {

        cbURL = "http://www.cricbuzz.com/profiles/6326/";
        getBattingStats(cbURL);
    }

    @Test
    public void T4testPlayerCP() {

        cbURL = "http://www.cricbuzz.com/profiles/521/";
        getBattingStats(cbURL);
    }

    @Test
    public void T5testPlayerVK() {

        cbURL = "http://www.cricbuzz.com/profiles/201/";
        getBattingStats(cbURL);
    }

    @Test
    public void T6testPlayerAR() {

        cbURL = "http://www.cricbuzz.com/profiles/1459/";
        getBattingStats(cbURL);
    }

    @Test
    public void T7testPlayerSB() {

        cbURL = "http://www.cricbuzz.com/profiles/1396/";
        getBattingStats(cbURL);
    }

    @Test
    public void T8testPlayerRS() {

        cbURL = "http://www.cricbuzz.com/profiles/9552/";
        getBattingStats(cbURL);
    }

    @Test
    public void T9testPlayerIS() {

        cbURL = "http://www.cricbuzz.com/profiles/1057/";
        getBattingStats(cbURL);
    }

    @Test
    public void T11testPlayerMS() {

        cbURL = "http://www.cricbuzz.com/profiles/9067/";
        getBattingStats(cbURL);
    }

    @Test
    public void T12testPlayerMS() {

        cbURL = "http://www.cricbuzz.com/profiles/8117/";
        getBattingStats(cbURL);
    }
    @Test
    public void T13testPlayerMS() {

        cbURL = "http://www.cricbuzz.com/profiles/7622/";
        getBattingStats(cbURL);
    }
    @Test
    public void T14testPlayerMS() {

        cbURL = "http://www.cricbuzz.com/profiles/2255/";
        getBattingStats(cbURL);
    }
    @Test
    public void T10testPlayerMS() {

        cbURL = "http://www.cricbuzz.com/profiles/2257/";
        getBattingStats(cbURL);
    }
    @Test
    public void T15testPlayerMS() {

        cbURL = "http://www.cricbuzz.com/profiles/8982/";
        getBattingStats(cbURL);
    }

}