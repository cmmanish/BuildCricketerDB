package com.cricket.stats.tests;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static com.cricket.stats.utils.QaConstants.CRICBUZZ_PROFILE_BASE_URL;

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

        cbURL = CRICBUZZ_PROFILE_BASE_URL+"1457/";
        extractBattingStats(cbURL);
    }

    @Test
    public void T2testPlayerSD() {

        cbURL = CRICBUZZ_PROFILE_BASE_URL+"8216/";
        extractBattingStats(cbURL);
    }

    @Test
    public void T3testPlayerLR() {

        cbURL = CRICBUZZ_PROFILE_BASE_URL+"6326/";
        extractBattingStats(cbURL);
    }

    @Test
    public void T4testPlayerCP() {

        cbURL = CRICBUZZ_PROFILE_BASE_URL+"521/";
        extractBattingStats(cbURL);
    }

    @Test
    public void T5testPlayerVK() {

        cbURL = CRICBUZZ_PROFILE_BASE_URL+"201/";
        extractBattingStats(cbURL);
    }

    @Test
    public void T6testPlayerAR() {

        cbURL = CRICBUZZ_PROFILE_BASE_URL+"1459/";
        extractBattingStats(cbURL);
    }

    @Test
    public void T7testPlayerSB() {

        cbURL = CRICBUZZ_PROFILE_BASE_URL+"1396/";
        extractBattingStats(cbURL);
    }

    @Test
    public void T8testPlayerRS() {

        cbURL = CRICBUZZ_PROFILE_BASE_URL+"9552/";
        extractBattingStats(cbURL);
    }

    @Test
    public void T9testPlayerIS() {

        cbURL = CRICBUZZ_PROFILE_BASE_URL+"1057/";
        extractBattingStats(cbURL);
    }

    @Test
    public void T11testPlayerMS() {

        cbURL = CRICBUZZ_PROFILE_BASE_URL+"9067/";
        extractBattingStats(cbURL);
    }

    @Test
    public void T12testPlayerMS() {

        cbURL = CRICBUZZ_PROFILE_BASE_URL+"8117/";
        extractBattingStats(cbURL);
    }
    @Test
    public void T13testPlayerMS() {

        cbURL = CRICBUZZ_PROFILE_BASE_URL+"7622/";
        extractBattingStats(cbURL);
    }
    @Test
    public void T14testPlayerMS() {

        cbURL = CRICBUZZ_PROFILE_BASE_URL+"2255/";
        extractBattingStats(cbURL);
    }
    @Test
    public void T10testPlayerMS() {

        cbURL = CRICBUZZ_PROFILE_BASE_URL+"2257/";
        extractBattingStats(cbURL);
    }
    @Test
    public void T15testPlayerMS() {

        cbURL = CRICBUZZ_PROFILE_BASE_URL+"8982/";
        extractBattingStats(cbURL);
    }

}