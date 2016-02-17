package com.cricket.stats.database;

import com.cricket.stats.util.QaProperties;
import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.File;
import java.io.FileReader;
import java.sql.*;

public class SQLiteJDBC {
    public static Logger log = Logger.getLogger(SQLiteJDBC.class);

    public static String[] countryList = {"IND", "AUS", "ENG", "PAK", "SL", "SA", "NZ", "WI"};
    protected static String fileName = "PlayerStats.json";
    protected static String jsonDIR = QaProperties.getJSONDir();
    private String JDBCConnection = "org.sqlite.JDBC";
    private String dbConectionString = "jdbc:sqlite:PavilionService/database/CRICKET.db";
    protected String playerName, cbURL, country = "";
    protected int id, tests, innings, runs, highestScore, notOuts, hundreds, fifties, fours, sixes = 0;
    protected double batAvg, strikeRate = 0.00;

    public static void main(String args[]) {

        SQLiteJDBC sqliteJDBC = new SQLiteJDBC();
        sqliteJDBC.dbConnect();
        sqliteJDBC.deleteDB("");
        for (String countryId : countryList) {
            String filePath = jsonDIR + File.separator + countryId + fileName;
            sqliteJDBC.readJSON(filePath, countryId);
        }
        log.info(sqliteJDBC.getRowCount());
   //     sqliteJDBC.selectRow();
    }

    public void dbConnect() {
        Connection c = null;
        try {
            Class.forName(JDBCConnection);
            c = DriverManager.getConnection(dbConectionString);

        } catch (Exception e) {
            log.error(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        log.info("database Connected successfully");
    }

    public boolean createTable() {
        {
            Connection c = null;
            Statement stmt = null;
            try {
                Class.forName(JDBCConnection);
                c = DriverManager.getConnection(dbConectionString);
                log.error("Opened database successfully");

                stmt = c.createStatement();
                String sql = "CREATE TABLE PLAYER " +
                        "(id INTEGER PRIMARY KEY    NOT NULL," +
                        " player_name           TEXT    NOT NULL, " +
                        " country           TEXT    NOT NULL, " +
                        " tests            INTEGER     NOT NULL, " +
                        " innings            INTEGER     NOT NULL, " +
                        " runs            INTEGER     NOT NULL, " +
                        " highest_score            INTEGER     NOT NULL, " +
                        " bat_avg            REAL     NOT NULL, " +
                        " strike_rate            REAL     NOT NULL, " +
                        " not_outs            INTEGER     NOT NULL, " +
                        " hundreds            INTEGER     NOT NULL, " +
                        " fifties            INTEGER     NOT NULL, " +
                        " sixes            INTEGER     NOT NULL, " +
                        " fours            INTEGER     NOT NULL, " +
                        " cb_url            TEXT     NOT NULL) ";
                log.info("sql: " + sql);
                stmt.executeUpdate(sql);
                stmt.close();
                c.close();
                log.info("Table created successfully");
                return true;
            } catch (Exception e) {
                log.error(e);
                return false;
            }
        }
    }

    public boolean insertIntoDatabase(String countryId) {
        boolean flag = false;
        Connection conn = null;
        try {
            Class.forName(JDBCConnection);
            conn = DriverManager.getConnection(dbConectionString);
            conn.setAutoCommit(false);
            String query = "INSERT OR IGNORE INTO PLAYER (id, player_name, tests, innings, runs, highest_score, bat_avg, strike_rate, not_outs, hundreds, fifties, sixes, fours, cb_url,country )" +
                    " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";

            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, id);
            stmt.setString(2, playerName);
            stmt.setInt(3, tests);
            stmt.setInt(4, innings);
            stmt.setInt(5, runs);
            stmt.setInt(6, highestScore);
            stmt.setDouble(7, batAvg);
            stmt.setDouble(8, strikeRate);
            stmt.setInt(9, notOuts);
            stmt.setInt(10, hundreds);
            stmt.setInt(11, fifties);
            stmt.setInt(12, sixes);
            stmt.setInt(13, fours);
            stmt.setString(14, cbURL);
            stmt.setString(15, country);

            stmt.executeUpdate();
            stmt.close();
            conn.commit();
            //conn.close();
            log.info("Inserted " + playerName + " successfully");
            flag = true;
        } catch (java.sql.SQLException sql) {
            log.error(sql);
        } catch (Exception e) {
            log.error(e);
        }
        return flag;
    }

    public void deleteDB(String str) {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName(JDBCConnection);
            c = DriverManager.getConnection(dbConectionString);
            c.setAutoCommit(false);

            stmt = c.createStatement();
            String sql = "DELETE from PLAYER;";
            stmt.executeUpdate(sql);
            //c.commit();
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        log.info("deleteDB Operation done");
    }

    public int getRowCount() {
        Connection c = null;
        Statement stmt = null;
        int count = 0;
        try {
            Class.forName(JDBCConnection);
            c = DriverManager.getConnection(dbConectionString);
            c.setAutoCommit(false);

            stmt = c.createStatement();
            String sql = "select count (*) as Rows from PLAYER;";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                count = rs.getInt("Rows");
            }
            //c.commit();
            stmt.close();
            c.close();
            return count;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public int selectRow() {
        Connection c = null;
        Statement stmt = null;
        int count = 0;
        try {
            Class.forName(JDBCConnection);
            c = DriverManager.getConnection(dbConectionString);
            c.setAutoCommit(false);

            stmt = c.createStatement();
            String sql = "select *  from PLAYER where country = 'IND';";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                count = rs.getInt("Rows");
            }
            //c.commit();
            stmt.close();
            c.close();
            return count;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public boolean readJSON(String filePath, String countryId) {

        log.info(countryId);
        try {
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(new FileReader(filePath));
            JSONObject jsonObject = (JSONObject) obj;
            JSONArray playerList = (JSONArray) jsonObject.get("Players");

            for (int i = 0; i < playerList.size(); i++) {
                JSONObject eachPlayer = (JSONObject) playerList.get(i);

                id = Integer.parseInt(eachPlayer.get("id").toString());
                country = eachPlayer.get("country").toString();
                playerName = eachPlayer.get("playerName").toString();

                tests = Integer.parseInt(eachPlayer.get("tests").toString());
                innings = Integer.parseInt(eachPlayer.get("innings").toString());
                runs = Integer.parseInt(eachPlayer.get("runs").toString());
                highestScore = Integer.parseInt(eachPlayer.get("highestScore").toString());

                batAvg = Double.parseDouble(eachPlayer.get("batAvg").toString());
                strikeRate = Double.parseDouble(eachPlayer.get("strikeRate").toString());

                notOuts = Integer.parseInt(eachPlayer.get("notOuts").toString());
                hundreds = Integer.parseInt(eachPlayer.get("hundreds").toString());
                fifties = Integer.parseInt(eachPlayer.get("fifties").toString());
                sixes = Integer.parseInt(eachPlayer.get("sixes").toString());
                fours = Integer.parseInt(eachPlayer.get("fours").toString());
                cbURL = eachPlayer.get("cbURL").toString();

                insertIntoDatabase(countryId);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}