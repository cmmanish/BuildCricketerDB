package com.cricket.stats.tests;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static com.cricket.stats.utils.QaConstants.CRICBUZZ_PROFILE_BASE_URL;

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

        cbURL = CRICBUZZ_PROFILE_BASE_URL+"247/";
        extractBattingStats(cbURL);
    }

    @Test
    public void T2testPlayerSD() {

        cbURL = CRICBUZZ_PROFILE_BASE_URL+"1984/";
        extractBattingStats(cbURL);
    }

    @Test
    public void T3testPlayerLR() {

        cbURL = CRICBUZZ_PROFILE_BASE_URL+"7748/";
        extractBattingStats(cbURL);
    }

    @Test
    public void T4testPlayerCP() {

        cbURL = CRICBUZZ_PROFILE_BASE_URL+"1610/";
        extractBattingStats(cbURL);
    }

    @Test
    public void T5testPlayerVK() {

        cbURL = CRICBUZZ_PROFILE_BASE_URL+"244/";
        extractBattingStats(cbURL);
    }

    @Test
    public void T6testPlayerAR() {

        cbURL = CRICBUZZ_PROFILE_BASE_URL+"9400/";
        extractBattingStats(cbURL);
    }

    @Test
    public void T7testPlayerSB() {

        cbURL = CRICBUZZ_PROFILE_BASE_URL+"399/";
        extractBattingStats(cbURL);
    }

    @Test
    public void T8testPlayerRS() {

        cbURL = CRICBUZZ_PROFILE_BASE_URL+"379/";
        extractBattingStats(cbURL);
    }

    @Test
    public void T9testPlayerIS() {

        cbURL = CRICBUZZ_PROFILE_BASE_URL+"1359/";
        extractBattingStats(cbURL);
    }

    @Test
    public void T11testPlayerMS() {

        cbURL = CRICBUZZ_PROFILE_BASE_URL+"1117/";
        extractBattingStats(cbURL);
    }

    @Test
    public void T12testPlayerMS() {

        cbURL = CRICBUZZ_PROFILE_BASE_URL+"8092/";
        extractBattingStats(cbURL);
    }
    @Test
    public void T13testPlayerMS() {

        cbURL = CRICBUZZ_PROFILE_BASE_URL+"6482/";
        extractBattingStats(cbURL);
    }
    @Test
    public void T14testPlayerMS() {

        cbURL = CRICBUZZ_PROFILE_BASE_URL+"8313/";
        extractBattingStats(cbURL);
    }
    @Test
    public void T10testPlayerMS() {

        cbURL = CRICBUZZ_PROFILE_BASE_URL+"242/";
        extractBattingStats(cbURL);
    }
    @Test
    public void T15testPlayerMS() {

        cbURL = CRICBUZZ_PROFILE_BASE_URL+"381/";
        extractBattingStats(cbURL);
    }

}