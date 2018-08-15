package com.cricket.stats.tests;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static com.cricket.stats.utils.QaConstants.CRICBUZZ_PROFILE_BASE_URL;

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

        cbURL = CRICBUZZ_PROFILE_BASE_URL+"7952/";
        getBattingStats(cbURL);
    }

    @Test
    public void T2testPlayerSD() {

        cbURL = CRICBUZZ_PROFILE_BASE_URL+"1978/";
        getBattingStats(cbURL);
    }

    @Test
    public void T3testPlayerLR() {

        cbURL = CRICBUZZ_PROFILE_BASE_URL+"104/";
        getBattingStats(cbURL);
    }

    @Test
    public void T4testPlayerCP() {

        cbURL = CRICBUZZ_PROFILE_BASE_URL+"6243/";
        getBattingStats(cbURL);
    }

    @Test
    public void T5testPlayerVK() {

        cbURL = CRICBUZZ_PROFILE_BASE_URL+"1629/";
        getBattingStats(cbURL);
    }

    @Test
    public void T6testPlayerAR() {

        cbURL = CRICBUZZ_PROFILE_BASE_URL+"6245/";
        getBattingStats(cbURL);
    }

    @Test
    public void T7testPlayerSB() {

        cbURL = CRICBUZZ_PROFILE_BASE_URL+"305/";
        getBattingStats(cbURL);
    }

    @Test
    public void T8testPlayerRS() {

        cbURL = CRICBUZZ_PROFILE_BASE_URL+"516/";
        getBattingStats(cbURL);
    }

    @Test
    public void T9testPlayerIS() {

        cbURL = CRICBUZZ_PROFILE_BASE_URL+"277/";
        getBattingStats(cbURL);
    }

    @Test
    public void T10testPlayerMS() {

        cbURL = CRICBUZZ_PROFILE_BASE_URL+"8445/";
        getBattingStats(cbURL);
    }

    @Test
    public void T11testPlayerBK() {

        cbURL = CRICBUZZ_PROFILE_BASE_URL+"8393/";
        getBattingStats(cbURL);
    }

    @Test
    public void T12testPlayerUY() {

        cbURL = CRICBUZZ_PROFILE_BASE_URL+"6730/";
        getBattingStats(cbURL);
    }

    @Test
    public void T13testPlayerRA() {

        cbURL = CRICBUZZ_PROFILE_BASE_URL+"414/";
        getBattingStats(cbURL);
    }

    @Test
    public void T14testPlayerAM() {

        cbURL = CRICBUZZ_PROFILE_BASE_URL+"812/";
        getBattingStats(cbURL);
    }

    @Test
    public void T15testPlayerWS() {

        cbURL = CRICBUZZ_PROFILE_BASE_URL+"8413/";
        getBattingStats(cbURL);
    }
}