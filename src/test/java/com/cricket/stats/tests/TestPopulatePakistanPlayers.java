package com.cricket.stats.tests;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static com.cricket.stats.utils.QaConstants.CRICBUZZ_PROFILE_BASE_URL;

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
    public void T1testPlayer() {

        cbURL = CRICBUZZ_PROFILE_BASE_URL+"360/";
        extractBattingStats(cbURL);
    }

    @Test
    public void T2testPlayer() {

        cbURL = CRICBUZZ_PROFILE_BASE_URL+"8370/";
        extractBattingStats(cbURL);
    }

    @Test
    public void T3testPlayer() {

        cbURL = CRICBUZZ_PROFILE_BASE_URL+"130/";
        extractBattingStats(cbURL);
    }

    @Test
    public void T4testPlayer() {

        cbURL = CRICBUZZ_PROFILE_BASE_URL+"274/";
        extractBattingStats(cbURL);
    }

    @Test
    public void T5testPlayer() {

        cbURL = CRICBUZZ_PROFILE_BASE_URL+"6481/";
        extractBattingStats(cbURL);
    }

    @Test
    public void T6testPlayer() {

        cbURL = CRICBUZZ_PROFILE_BASE_URL+"881/";
        extractBattingStats(cbURL);
    }

    @Test
    public void T7testPlayer() {

        cbURL = CRICBUZZ_PROFILE_BASE_URL+"1051/";
        extractBattingStats(cbURL);
    }

    @Test
    public void T8testPlayer() {

        cbURL = CRICBUZZ_PROFILE_BASE_URL+"8064/";
        extractBattingStats(cbURL);
    }

    @Test
    public void T9testPlayer() {

        cbURL = CRICBUZZ_PROFILE_BASE_URL+"8991/";
        extractBattingStats(cbURL);
    }

    @Test
    public void T11testPlayer() {

        cbURL = CRICBUZZ_PROFILE_BASE_URL+"7900/";
        extractBattingStats(cbURL);
    }

    @Test
    public void T12testPlayer() {

        cbURL = CRICBUZZ_PROFILE_BASE_URL+"3647/";
        extractBattingStats(cbURL);
    }
    @Test
    public void T13testPlayer() {

        cbURL = CRICBUZZ_PROFILE_BASE_URL+"8359/";
        extractBattingStats(cbURL);
    }
    @Test
    public void T14testPlayer() {

        cbURL = CRICBUZZ_PROFILE_BASE_URL+"1053/";
        extractBattingStats(cbURL);
    }
    @Test
    public void T10testPlayer() {

        cbURL = CRICBUZZ_PROFILE_BASE_URL+"6633/";
        extractBattingStats(cbURL);
    }
    @Test
    public void T15testPlayer() {

        cbURL = CRICBUZZ_PROFILE_BASE_URL+"8301/";
        extractBattingStats(cbURL);
    }
}