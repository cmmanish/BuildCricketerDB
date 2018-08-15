package com.cricket.stats.tests;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static com.cricket.stats.utils.QaConstants.CRICBUZZ_PROFILE_BASE_URL;

/**
 * Created by mmadhusoodan on 1/13/2015.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestPopulateEnglandPlayers extends AbstractbBaseClass {

    static String country = "ENG";
    static String fileName = country +"PlayerStats.json";

    public TestPopulateEnglandPlayers() {
        super(TestPopulateEnglandPlayers.fileName, TestPopulateEnglandPlayers.country);
    }

    @Test
    public void T1testPlayerMV() {

        cbURL = CRICBUZZ_PROFILE_BASE_URL+"6511/";
        extractBattingStats(cbURL);
    }

    @Test
    public void T2testPlayerSD() {

        cbURL = CRICBUZZ_PROFILE_BASE_URL+"488/";
        extractBattingStats(cbURL);
    }

    @Test
    public void T3testPlayerLR() {

        cbURL = CRICBUZZ_PROFILE_BASE_URL+"385/";
        extractBattingStats(cbURL);
    }

    @Test
    public void T4testPlayerCP() {

        cbURL = CRICBUZZ_PROFILE_BASE_URL+"8019/";
        extractBattingStats(cbURL);
    }

    @Test
    public void T5testPlayerVK() {

        cbURL = CRICBUZZ_PROFILE_BASE_URL+"6507/";
        extractBattingStats(cbURL);
    }

    @Test
    public void T6testPlayerAR() {

        cbURL = CRICBUZZ_PROFILE_BASE_URL+"6557/";
        extractBattingStats(cbURL);
    }

    @Test
    public void T7testPlayerSB() {

        cbURL = CRICBUZZ_PROFILE_BASE_URL+"2258/";
        extractBattingStats(cbURL);
    }

    @Test
    public void T8testPlayerRS() {

        cbURL = CRICBUZZ_PROFILE_BASE_URL+"8383/";
        extractBattingStats(cbURL);
    }

    @Test
    public void T9testPlayerIS() {

        cbURL = CRICBUZZ_PROFILE_BASE_URL+"6692/";
        extractBattingStats(cbURL);
    }

    @Test
    public void T10testPlayerMS() {

        cbURL = CRICBUZZ_PROFILE_BASE_URL+"554/";
        extractBattingStats(cbURL);
    }

    @Test
    public void T11testPlayerBK() {

        cbURL = CRICBUZZ_PROFILE_BASE_URL+"6317/";
        extractBattingStats(cbURL);
    }
}