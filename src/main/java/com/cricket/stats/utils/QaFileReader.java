package com.cricket.stats.utils;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.LogManager;
import java.util.logging.Logger;

/**
 * Created by mmadhusoodan on 4/15/15.
 */
public class QaFileReader {

    protected static Logger log = LogManager.getLogManager().getLogger(String.valueOf(QaFileReader.class));

    private static String testrailDir = QaProperties.getJSONDir();
    String fileName = QaConstants.IND_PLAYER_STATS_FILE_JSON;
    String filePath = testrailDir + File.separator + fileName;
    File file = new File(filePath);
    JSONParser parser = new JSONParser();
    List<String> testcaseList = new ArrayList<String>();

    public List<String> getFailedTestCaseListFromTestrailsJSON() {
        try

        {
            Object obj = parser.parse(new FileReader(file));
            JSONObject jsonObject = (JSONObject) obj;
            JSONArray testcaseArray = (JSONArray) jsonObject.get("resultsList");

            for (int i = 0; i < testcaseArray.size(); i++) {
                JSONObject testcaseJSONObject = (JSONObject) testcaseArray.get(i);
                String runStatus = testcaseJSONObject.get("runStatus").toString();
                if ("failed".equalsIgnoreCase(runStatus)) {
                    testcaseList.add(testcaseJSONObject.get("testSectionName").toString() + " : " + testcaseJSONObject.get("testName").toString());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return testcaseList;
    }

    public static void main(String[] args) {
        QaFileReader qaFileReader = new QaFileReader();

        String body = "";
        List<String> testcaseList = qaFileReader.getFailedTestCaseListFromTestrailsJSON();
        Iterator<String> iterator = testcaseList.iterator();

        while (iterator.hasNext()) {
            body = body + iterator.next() + "\n";
        }
        log.info(body);

    }
}
