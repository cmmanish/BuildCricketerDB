package com.cricket.stats.tests;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

/**
 * Created by mmadhusoodan on 1/13/2015.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestPopulateSriLankaPlayers extends AbstractbBaseClass {

    static String country = "SL";
    static String fileName = country +"PlayerStats.json";

    public TestPopulateSriLankaPlayers() {
        super(TestPopulateSriLankaPlayers.fileName, TestPopulateSriLankaPlayers.country);

    }

    @Test
    public void T1testPlayerMV() {

        cbURL = "http://www.cricbuzz.com/profiles/7952/";
        getBattingStats(cbURL);
    }

    @Test
    public void T2testPlayerSD() {

        cbURL = "http://www.cricbuzz.com/profiles/1978/";
        getBattingStats(cbURL);
    }

    @Test
    public void T3testPlayerLR() {

        cbURL = "http://www.cricbuzz.com/profiles/104/";
        getBattingStats(cbURL);
    }

    @Test
    public void T4testPlayerCP() {

        cbURL = "http://www.cricbuzz.com/profiles/6243/";
        getBattingStats(cbURL);
    }

    @Test
    public void T5testPlayerVK() {

        cbURL = "http://www.cricbuzz.com/profiles/1629/";
        getBattingStats(cbURL);
    }

    @Test
    public void T6testPlayerAR() {

        cbURL = "http://www.cricbuzz.com/profiles/6245/";
        getBattingStats(cbURL);
    }

    @Test
    public void T7testPlayerSB() {

        cbURL = "http://www.cricbuzz.com/profiles/305/";
        getBattingStats(cbURL);
    }

    @Test
    public void T8testPlayerRS() {

        cbURL = "http://www.cricbuzz.com/profiles/516/";
        getBattingStats(cbURL);
    }

    @Test
    public void T9testPlayerIS() {

        cbURL = "http://www.cricbuzz.com/profiles/277/";
        getBattingStats(cbURL);
    }

    @Test
    public void T10testPlayerMS() {

        cbURL = "http://www.cricbuzz.com/profiles/8445/";
        getBattingStats(cbURL);
    }

    @Test
    public void T11testPlayerBK() {

        cbURL = "http://www.cricbuzz.com/profiles/8393/";
        getBattingStats(cbURL);
    }

    @Test
    public void T12testPlayerUY() {

        cbURL = "http://www.cricbuzz.com/profiles/6730/";
        getBattingStats(cbURL);
    }

    @Test
    public void T13testPlayerRA() {

        cbURL = "http://www.cricbuzz.com/profiles/414/";
        getBattingStats(cbURL);
    }

    @Test
    public void T14testPlayerAM() {

        cbURL = "http://www.cricbuzz.com/profiles/812/";
        getBattingStats(cbURL);
    }

    @Test
    public void T15testPlayerWS() {

        cbURL = "http://www.cricbuzz.com/profiles/8413/";
        getBattingStats(cbURL);
    }
}