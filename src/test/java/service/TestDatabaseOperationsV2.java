package service;

import com.cricket.stats.database.SQLiteJDBCV2;
import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.logging.Logger;

import static com.cricket.stats.utils.QaConstants.PLAYER_JSON_LOCATION;
import static com.cricket.stats.utils.QaConstants.PLAYER_STATS_FILE_JSON;

public class TestDatabaseOperationsV2 {

    public static Logger log = Logger.getLogger(String.valueOf(TestDatabaseOperationsV2.class));

    Instant start, end;
    @Before
    public void beforeTest(){
        start = Instant.now();
    }

    @After
    public void afterTest(){
        end = Instant.now();
        Duration timeElapsed = Duration.between(start, end);
        System.out.println("Time taken: "+ timeElapsed.toMillis() +" milliseconds");
    }
    @Test
    public void populateNow() {
        try {
            SQLiteJDBCV2 sqliteJDBCV2 = new SQLiteJDBCV2();
            sqliteJDBCV2.dbConnect();
            sqliteJDBCV2.deleteAllRow();
            String filePath = PLAYER_JSON_LOCATION + File.separator + "XXX" + PLAYER_STATS_FILE_JSON;
            sqliteJDBCV2.readJSONAndInsertToDatabase(filePath);
            log.info("Row Count " + sqliteJDBCV2.getRowCount());

        } catch (Exception e) {
            e.getLocalizedMessage();
        }
    }

    @Test
    public void TestCreateTableV2() {
        try {
            SQLiteJDBCV2 sqliteJDBCV2 = new SQLiteJDBCV2();
            Assert.assertEquals(true, sqliteJDBCV2.createTable());
        } catch (Exception e) {
            e.getLocalizedMessage();
        }
    }

    @Test
    public void TestShowINDPLayersV2() {
        try {
            SQLiteJDBCV2 sqliteJDBCV2 = new SQLiteJDBCV2();
            List playerList = sqliteJDBCV2.getPlayerNameFromDatabase("India");
            for (int i = 0; i < playerList.size(); i++)
                log.info(playerList.get(i).toString());
        } catch (Exception e) {
            e.getLocalizedMessage();
        }
    }

    @Test
    public void TestShowGreatBatsmenV2() {
        try {
            SQLiteJDBCV2 sqliteJDBCV2 = new SQLiteJDBCV2();
            List playerList = sqliteJDBCV2.getGreatBatsmenFromDatabase();
            for (int i = 0; i < playerList.size(); i++)
                log.info(playerList.get(i).toString());
        } catch (Exception e) {
            e.getLocalizedMessage();
        }
    }

    @Test
    public void TestDropTableV2() {
        SQLiteJDBCV2 sqliteJDBCV2 = new SQLiteJDBCV2();
        Assert.assertEquals(true, sqliteJDBCV2.dropTable());
    }

    @Test
    public void TestGetRowCountV2() {
        SQLiteJDBCV2 sqliteJDBCV2 = new SQLiteJDBCV2();
        log.info("Row Count " + sqliteJDBCV2.getRowCount());
    }
}