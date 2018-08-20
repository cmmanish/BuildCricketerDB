package com.cricket.stats.database;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class SQLiteJDBCV2 {
    public static Logger log = Logger.getLogger(String.valueOf(SQLiteJDBCV2.class));

    protected static String fileName = "XXXPlayerStats.json";

    private String JDBCConnection = "org.sqlite.JDBC";
    private String dbConectionString = "jdbc:sqlite:PavilionService/database/CRICKET_V2.db";
    protected String playerName, country = "";
    protected int cricbuzzId, tests, innings, runs, highestScore, notOuts, hundreds, fifties, fours, sixes = 0;
    protected double batAvg, strikeRate = 0.00;

    public void dbConnect() {
        Connection c = null;
        try {
            Class.forName(JDBCConnection);
            c = DriverManager.getConnection(dbConectionString);

        } catch (Exception e) {
            log.info(e.getClass().getName() + ": " + e.getMessage());
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
                log.info("Opened database successfully");

                stmt = c.createStatement();
                String sql = "CREATE TABLE PLAYER " +
                        "(cricbuzz_id INTEGER PRIMARY KEY    NOT NULL," +
                        " player_name           TEXT    NOT NULL, " +
                        " tests            INTEGER     NOT NULL, " +
                        " runs            INTEGER     NOT NULL, " +
                        " highest_score            INTEGER     NOT NULL, " +
                        " bat_avg            REAL     NOT NULL, " +
                        " hundreds            INTEGER     NOT NULL, " +
                        " fifties            INTEGER     NOT NULL, " +
                        " sixes            INTEGER     NOT NULL, " +
                        " fours            INTEGER     NOT NULL, " +
                        " country           TEXT    NOT NULL ) ";
                log.info("sql: " + sql);
                stmt.executeUpdate(sql);
                stmt.close();
                c.close();
                log.info("Table created successfully");
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
    }

    public boolean insertIntoDatabase() {
        boolean flag = false;
        Connection conn = null;
        try {
            Class.forName(JDBCConnection);
            conn = DriverManager.getConnection(dbConectionString);
            conn.setAutoCommit(false);
            String query = "INSERT INTO PLAYER (cricbuzz_id, player_name, tests, runs, highest_score, bat_avg, " +
                    "hundreds, fifties, sixes, fours, country )" +
                    " VALUES (?,?,?,?,?,?,?,?,?,?,?);";

            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, cricbuzzId);
            stmt.setString(2, playerName);
            stmt.setInt(3, tests);
            stmt.setInt(4, runs);
            stmt.setInt(5, highestScore);
            stmt.setDouble(6, batAvg);
            stmt.setInt(7, hundreds);
            stmt.setInt(8, fifties);
            stmt.setInt(9, sixes);
            stmt.setInt(10, fours);
            stmt.setString(11, country);

            stmt.executeUpdate();
            stmt.close();
            conn.commit();
            conn.close();
            log.info("Inserted " + playerName + " successfully");
            flag = true;
        } catch (SQLException sql) {
            sql.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    public boolean dropTable() {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName(JDBCConnection);
            c = DriverManager.getConnection(dbConectionString);
            c.setAutoCommit(false);

            stmt = c.createStatement();
            String sql = "DROP TABLE PLAYER;";
            int a = stmt.executeUpdate(sql);
            c.commit();
            stmt.close();
            c.close();
            log.info("dropTable Operation done");
            return true;
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            return false;
        }

    }

    public void deleteAllRow() {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName(JDBCConnection);
            c = DriverManager.getConnection(dbConectionString);
            c.setAutoCommit(false);

            stmt = c.createStatement();
            String sql = "DELETE from PLAYER;";
            int a = stmt.executeUpdate(sql);
            c.commit();
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        log.info("deleteAllRow Operation done");
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
            String sql = "select count(*) from PLAYER;";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                count = rs.getInt(1);
            }
            c.commit();
            stmt.close();
            c.close();
            return count;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public List<String> getPlayerNameFromDatabase(String country) {
        Connection c = null;
        Statement stmt = null;
        List<String> playerNameList = new ArrayList<String>();

        if (country.equals("")){
            return playerNameList;
        }
        try {
            Class.forName(JDBCConnection);
            c = DriverManager.getConnection(dbConectionString);
            c.setAutoCommit(false);

            stmt = c.createStatement();
            String sql = "select player_name from PLAYER where country=" + "'"+country+"'";
            log.info(sql);
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                playerNameList.add(rs.getString("player_name"));
            }
            c.commit();
            stmt.close();
            c.close();
            return  playerNameList;
        } catch (Exception e) {
            log.warning(e.getMessage());
            return playerNameList;
        }
    }

    public int showTable() {
        Connection c = null;
        Statement stmt = null;
        int count = 0;
        try {
            Class.forName(JDBCConnection);
            c = DriverManager.getConnection(dbConectionString);
            c.setAutoCommit(false);

            stmt = c.createStatement();
            String sql = "SHOW TABLES ";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                count = rs.getInt("Rows");
            }
            c.commit();
            stmt.close();
            c.close();
            return count;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public boolean readJSONAndInsertToDatabase(String filePath) {

        try {
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(new FileReader(filePath));
            JSONObject jsonObject = (JSONObject) obj;
            JSONArray playerList = (JSONArray) jsonObject.get("Players");

            log.info("Total players: " + playerList.size());
            for (int i = 0; i < playerList.size(); i++) {
                JSONObject eachPlayer = (JSONObject) playerList.get(i);
                cricbuzzId = Integer.parseInt(eachPlayer.get("cricbuzzId").toString());
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

                insertIntoDatabase();
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}