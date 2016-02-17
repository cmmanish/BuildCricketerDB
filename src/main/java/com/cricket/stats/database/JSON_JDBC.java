package com.cricket.stats.database;

/**
 * Created by mmadhusoodan on 2/16/16.
 */
public class JSON_JDBC {

//    public boolean readJSON() {
//
//        try {
//            JSONParser parser = new JSONParser();
//
//            for (String countryId : countryList) {
//                String filePath = jsonDIR + File.separator + countryId + fileName;
//
//                Object obj = parser.parse(new FileReader(filePath));
//                JSONObject jsonObject = (JSONObject) obj;
//                JSONArray playerList = (JSONArray) jsonObject.get("Players");
//
//                for (int i = 0; i < playerList.size(); i++) {
//
//                    JSONObject eachPlayer = (JSONObject) playerList.get(i);
//
//                    id = Integer.parseInt(eachPlayer.get("id").toString());
//                    country = eachPlayer.get("country").toString();
//                    playerName = eachPlayer.get("playerName").toString();
//
//                    tests = Integer.parseInt(eachPlayer.get("tests").toString());
//                    innings = Integer.parseInt(eachPlayer.get("innings").toString());
//                    runs = Integer.parseInt(eachPlayer.get("runs").toString());
//                    highestScore = Integer.parseInt(eachPlayer.get("highestScore").toString());
//
//                    batAvg = Double.parseDouble(eachPlayer.get("batAvg").toString());
//                    strikeRate = Double.parseDouble(eachPlayer.get("strikeRate").toString());
//
//                    notOuts = Integer.parseInt(eachPlayer.get("notOuts").toString());
//                    hundreds = Integer.parseInt(eachPlayer.get("hundreds").toString());
//                    fifties = Integer.parseInt(eachPlayer.get("fifties").toString());
//                    sixes = Integer.parseInt(eachPlayer.get("sixes").toString());
//                    fours = Integer.parseInt(eachPlayer.get("fours").toString());
//                    cbURL = eachPlayer.get("cbURL").toString();
//
//                    insertIntoDatabase(countryId);
//                }
//            }
//            return true;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return false;
//        }
//    }
}
