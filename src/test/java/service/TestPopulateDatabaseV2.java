package service;

import com.cricket.stats.database.SQLiteJDBCV2;
import junit.framework.Assert;
import org.junit.Test;

import java.io.File;
import java.util.logging.Logger;

import static com.cricket.stats.utils.QaConstants.PLAYER_JSON_LOCATION;
import static com.cricket.stats.utils.QaConstants.PLAYER_STATS_FILE_JSON;

public class TestPopulateDatabaseV2 {

    public static Logger log = Logger.getLogger(String.valueOf(TestPopulateDatabaseV2.class));

    @Test
    public void populateNow() {

        try {
            SQLiteJDBCV2 sqliteJDBCV2 = new SQLiteJDBCV2();
            sqliteJDBCV2.dbConnect();
            sqliteJDBCV2.deleteAllRow();
            String filePath = PLAYER_JSON_LOCATION + File.separator + "XXX" + PLAYER_STATS_FILE_JSON;
            sqliteJDBCV2.readJSONAndInsertToDatabase(filePath);
            log.info("Row Count " + sqliteJDBCV2.getRowCount());
            sqliteJDBCV2.selectRow();
        } catch (Exception e) {
            e.printStackTrace();
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
    public void TestShowTableV2() {
        try {
            SQLiteJDBCV2 sqliteJDBCV2 = new SQLiteJDBCV2();
            log.info(sqliteJDBCV2.showTable() + "");
        } catch (Exception e) {
            e.getLocalizedMessage();
        }
    }

    @Test
    public void TestDropTableV2() {
        SQLiteJDBCV2 sqliteJDBCV2 = new SQLiteJDBCV2();
        Assert.assertEquals(true,sqliteJDBCV2.dropTable());
    }

    @Test
    public void TestGetRowCountV2() {
        SQLiteJDBCV2 sqliteJDBCV2 = new SQLiteJDBCV2();
        log.info("Row Count " + sqliteJDBCV2.getRowCount());
    }
}

