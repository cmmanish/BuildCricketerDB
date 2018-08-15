package com.cricket.stats.tests;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static com.cricket.stats.utils.QaConstants.CRICBUZZ_PROFILE_BASE_URL;

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

        cbURL = CRICBUZZ_PROFILE_BASE_URL+"2288/";
        extractBattingStats(cbURL);
    }

    @Test
    public void T2testPlayerSD() {

        cbURL = CRICBUZZ_PROFILE_BASE_URL+"2239/";
        extractBattingStats(cbURL);
    }

    @Test
    public void T3testPlayerLR() {

        cbURL = CRICBUZZ_PROFILE_BASE_URL+"314/";
        extractBattingStats(cbURL);
    }

    @Test
    public void T4testPlayerCP() {

        cbURL = CRICBUZZ_PROFILE_BASE_URL+"7825/";
        extractBattingStats(cbURL);
    }

    @Test
    public void T5testPlayerVK() {

        cbURL = CRICBUZZ_PROFILE_BASE_URL+"8583/";
        extractBattingStats(cbURL);
    }

    @Test
    public void T6testPlayerAR() {

        cbURL = CRICBUZZ_PROFILE_BASE_URL+"731/";
        extractBattingStats(cbURL);
    }

    @Test
    public void T7testPlayerSB() {

        cbURL = CRICBUZZ_PROFILE_BASE_URL+"508/";
        extractBattingStats(cbURL);
    }

    @Test
    public void T8testPlayerRS() {

        cbURL = CRICBUZZ_PROFILE_BASE_URL+"9540/";
        extractBattingStats(cbURL);
    }

    @Test
    public void T9testPlayerIS() {

        cbURL = CRICBUZZ_PROFILE_BASE_URL+"608/";
        extractBattingStats(cbURL);
    }

    @Test
    public void T10testPlayerIS() {

        cbURL = CRICBUZZ_PROFILE_BASE_URL+"8099/";
        extractBattingStats(cbURL);
    }

    @Test
    public void T11testPlayerBK() {

        cbURL = CRICBUZZ_PROFILE_BASE_URL+"370/";
        extractBattingStats(cbURL);
    }

    @Test
    public void T12testPlayerBK() {

        cbURL = CRICBUZZ_PROFILE_BASE_URL+"585/";
        extractBattingStats(cbURL);
    }

    @Test
    public void T13testPlayerBK() {

        cbURL = CRICBUZZ_PROFILE_BASE_URL+"9585/";
        extractBattingStats(cbURL);
    }

    @Test
    public void T14testPlayerBK() {

        cbURL = CRICBUZZ_PROFILE_BASE_URL+"318/";
        extractBattingStats(cbURL);
    }

    @Test
    public void T15testPlayerBK() {

        cbURL = CRICBUZZ_PROFILE_BASE_URL+"8520/";
        extractBattingStats(cbURL);
    }
}