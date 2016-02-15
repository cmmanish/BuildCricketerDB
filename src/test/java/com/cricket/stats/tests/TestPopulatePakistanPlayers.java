package com.cricket.stats.tests;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

/**
 * Created by mmadhusoodan on 1/13/2015.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestPopulatePakistanPlayers extends AbstractbBaseClass {

    static String country = "PAK";
    static String fileName = country +"PlayerStats.json";

    public TestPopulatePakistanPlayers() {
        super(TestPopulatePakistanPlayers.fileName, TestPopulatePakistanPlayers.country);
    }

    @Test
    public void T1testPlayerMV() {

        cbURL = "http://www.cricbuzz.com/profiles/360/";
        getBattingStats(cbURL);
    }

    @Test
    public void T2testPlayerSD() {

        cbURL = "http://www.cricbuzz.com/profiles/8370/";
        getBattingStats(cbURL);
    }

    @Test
    public void T3testPlayerLR() {

        cbURL = "http://www.cricbuzz.com/profiles/130/";
        getBattingStats(cbURL);
    }

    @Test
    public void T4testPlayerCP() {

        cbURL = "http://www.cricbuzz.com/profiles/274/";
        getBattingStats(cbURL);
    }

    @Test
    public void T5testPlayerVK() {

        cbURL = "http://www.cricbuzz.com/profiles/6481/";
        getBattingStats(cbURL);
    }

    @Test
    public void T6testPlayerAR() {

        cbURL = "http://www.cricbuzz.com/profiles/881/";
        getBattingStats(cbURL);
    }

    @Test
    public void T7testPlayerSB() {

        cbURL = "http://www.cricbuzz.com/profiles/1051/";
        getBattingStats(cbURL);
    }

    @Test
    public void T8testPlayerRS() {

        cbURL = "http://www.cricbuzz.com/profiles/8064/";
        getBattingStats(cbURL);
    }

    @Test
    public void T9testPlayerIS() {

        cbURL = "http://www.cricbuzz.com/profiles/8991/";
        getBattingStats(cbURL);
    }

    @Test
    public void T11testPlayerMS() {

        cbURL = "http://www.cricbuzz.com/profiles/7900/";
        getBattingStats(cbURL);
    }

    @Test
    public void T12testPlayerMS() {

        cbURL = "http://www.cricbuzz.com/profiles/3647/";
        getBattingStats(cbURL);
    }
    @Test
    public void T13testPlayerMS() {

        cbURL = "http://www.cricbuzz.com/profiles/8359/";
        getBattingStats(cbURL);
    }
    @Test
    public void T14testPlayerMS() {

        cbURL = "http://www.cricbuzz.com/profiles/1053/";
        getBattingStats(cbURL);
    }
    @Test
    public void T10testPlayerMS() {

        cbURL = "http://www.cricbuzz.com/profiles/6633/";
        getBattingStats(cbURL);
    }
    @Test
    public void T15testPlayerMS() {

        cbURL = "http://www.cricbuzz.com/profiles/8301/";
        getBattingStats(cbURL);
    }

}