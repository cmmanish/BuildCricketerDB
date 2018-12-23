package service;

import com.cricket.stats.database.SQLiteJDBCV2;
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
    public void beforeTest() {
        start = Instant.now();
    }

    @After
    public void afterTest() {
        end = Instant.now();
        Duration timeElapsed = Duration.between(start, end);
        log.info("Time taken: " + timeElapsed.toMillis() + " milliseconds");
    }

    @Test

    public void databaseExists() {
        SQLiteJDBCV2 sqliteJDBCV2 = new SQLiteJDBCV2();
        assert sqliteJDBCV2.dbConnect();

    }

    @Test
    public void populateNow() {
        SQLiteJDBCV2 sqliteJDBCV2 = new SQLiteJDBCV2();
        sqliteJDBCV2.dbConnect();
        sqliteJDBCV2.deleteAllRow();
        String filePath = PLAYER_JSON_LOCATION + File.separator + "XXX" + PLAYER_STATS_FILE_JSON;
        sqliteJDBCV2.readJSONAndInsertToDatabase(filePath);
        log.info("Row Count " + sqliteJDBCV2.getRowCount());

    }

    @Test
    public void TestCreateTableV2() {
        SQLiteJDBCV2 sqliteJDBCV2 = new SQLiteJDBCV2();
        assert sqliteJDBCV2.createTable();
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
        assert sqliteJDBCV2.dropTable();
    }

    @Test
    public void TestGetRowCountV2() {
        SQLiteJDBCV2 sqliteJDBCV2 = new SQLiteJDBCV2();
        log.info("Row Count " + sqliteJDBCV2.getRowCount());
    }

    @Test
    public void TestShowTablesV2() {
        SQLiteJDBCV2 sqliteJDBCV2 = new SQLiteJDBCV2();
        log.info("Row Count " + sqliteJDBCV2.showTable());
        sqliteJDBCV2.showTable();
    }
}