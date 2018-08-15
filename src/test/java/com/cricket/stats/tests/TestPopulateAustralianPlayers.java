package com.cricket.stats.tests;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static com.cricket.stats.utils.QaConstants.CRICBUZZ_PROFILE_BASE_URL;

/**
 * Created by mmadhusoodan on 1/13/2015.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestPopulateAustralianPlayers extends AbstractbBaseClass {

    static String country = "AUS";
    static String fileName = country + "PlayerStats.json";

    public TestPopulateAustralianPlayers() {
        super(TestPopulateAustralianPlayers.fileName, TestPopulateAustralianPlayers.country);
    }

    @Test
    public void T1testPlayer() {

        cbURL = CRICBUZZ_PROFILE_BASE_URL + "1042/";
        extractBattingStats(cbURL);
    }

    @Test
    public void T2testPlayer() {

        cbURL = CRICBUZZ_PROFILE_BASE_URL + "1739/";
        extractBattingStats(cbURL);
    }

    @Test
    public void T3testPlayer() {

        cbURL = CRICBUZZ_PROFILE_BASE_URL + "2250/";
        extractBattingStats(cbURL);
    }

    @Test
    public void T4testPlayer() {

        cbURL = CRICBUZZ_PROFILE_BASE_URL + "138/";
        extractBattingStats(cbURL);
    }

    @Test
    public void T5testPlayer() {

        cbURL = CRICBUZZ_PROFILE_BASE_URL + "605/";
        extractBattingStats(cbURL);
    }

    @Test
    public void T6testPlayer() {

        cbURL = CRICBUZZ_PROFILE_BASE_URL + "6250/";
        extractBattingStats(cbURL);
    }

    @Test
    public void T7testPlayer() {

        cbURL = CRICBUZZ_PROFILE_BASE_URL + "7738/";
        extractBattingStats(cbURL);
    }

    @Test
    public void T8testPlayer() {

        cbURL = CRICBUZZ_PROFILE_BASE_URL + "496/";
        extractBattingStats(cbURL);
    }

    @Test
    public void T9testPlayer() {

        cbURL = CRICBUZZ_PROFILE_BASE_URL + "7710/";
        extractBattingStats(cbURL);
    }

    @Test
    public void T10testPlayer() {

        cbURL = CRICBUZZ_PROFILE_BASE_URL + "1444/";
        extractBattingStats(cbURL);
    }

    @Test
    public void T11testPlayer() {

        cbURL = CRICBUZZ_PROFILE_BASE_URL + "7850/";
        extractBattingStats(cbURL);
    }

    @Test
    public void T12testPlayer() {

        cbURL = CRICBUZZ_PROFILE_BASE_URL + "8095/";
        extractBattingStats(cbURL);
    }

    @Test
    public void T13testPlayer() {

        cbURL = CRICBUZZ_PROFILE_BASE_URL + "8969/";
        extractBattingStats(cbURL);
    }

    @Test
    public void T14testPlayer() {

        cbURL = CRICBUZZ_PROFILE_BASE_URL + "158/";
        extractBattingStats(cbURL);
    }

    @Test
    public void T15testPlayer() {

        cbURL = CRICBUZZ_PROFILE_BASE_URL + "563/";
        extractBattingStats(cbURL);
    }
}