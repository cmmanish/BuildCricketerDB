package com.cricket.stats.tests;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

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
        extractBattingStats(cbURL);
    }

    @Test
    public void T2testPlayerSD() {

        cbURL = CRICBUZZ_PROFILE_BASE_URL+"1446/";
        extractBattingStats(cbURL);
    }

    @Test
    public void T3testPlayerLR() {

        cbURL = CRICBUZZ_PROFILE_BASE_URL+"8733/";
        extractBattingStats(cbURL);
    }

    @Test
    public void T4testPlayerCP() {

        cbURL = CRICBUZZ_PROFILE_BASE_URL+"1448/";
        extractBattingStats(cbURL);
    }

    @Test
    public void T5testPlayerVK() {

        cbURL = CRICBUZZ_PROFILE_BASE_URL+"1413/";
        extractBattingStats(cbURL);
    }

    @Test
    public void T6testPlayerAR() {

        cbURL = CRICBUZZ_PROFILE_BASE_URL+"1447/";
        extractBattingStats(cbURL);
    }

    @Test
    public void T7testPlayerSB() {

        cbURL = CRICBUZZ_PROFILE_BASE_URL+"1530/";
        extractBattingStats(cbURL);
    }

    @Test
    public void T8testPlayerRS() {

        cbURL = CRICBUZZ_PROFILE_BASE_URL+"576/";
        extractBattingStats(cbURL);
    }

    @Test
    public void T9testPlayerIS() {

        cbURL = CRICBUZZ_PROFILE_BASE_URL+"702/";
        extractBattingStats(cbURL);
    }

    @Test
    public void T10testPlayerMS() {

        cbURL = CRICBUZZ_PROFILE_BASE_URL+"7909/";
        extractBattingStats(cbURL);
    }

    @Test
    public void T11testPlayerBK() {

        cbURL = CRICBUZZ_PROFILE_BASE_URL+"1726/";
        extractBattingStats(cbURL);
    }

    @Test
    public void T12testPlayerUY() {

        cbURL = CRICBUZZ_PROFILE_BASE_URL+"1858/";
        extractBattingStats(cbURL);
    }

    @Test
    public void T13testPlayerRA() {

        cbURL = CRICBUZZ_PROFILE_BASE_URL+"1593/";
        extractBattingStats(cbURL);
    }

    @Test
    public void T14testPlayerAM() {

        cbURL = CRICBUZZ_PROFILE_BASE_URL+"1454/";
        extractBattingStats(cbURL);
    }

    @Test
    public void T15testPlayerWS() {

        cbURL = CRICBUZZ_PROFILE_BASE_URL+"1465/";
        extractBattingStats(cbURL);
    }
}