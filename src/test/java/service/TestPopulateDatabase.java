package service;

import com.cricket.stats.database.SQLiteJDBC;
import org.junit.Test;

import java.io.File;
import java.util.logging.Logger;

import static com.cricket.stats.database.SQLiteJDBC.countryList;
import static com.cricket.stats.utils.QaConstants.PLAYER_JSON_LOCATION;
import static com.cricket.stats.utils.QaConstants.PLAYER_STATS_FILE_JSON;

public class TestPopulateDatabase {

    public static Logger log = Logger.getLogger(String.valueOf(TestPopulateDatabase.class));

    @Test
    public void populateNow() {

        try {
            SQLiteJDBC sqliteJDBC = new SQLiteJDBC();
            sqliteJDBC.dbConnect();
            //sqliteJDBC.deleteAllRow();
            for (String countryId : countryList) {
                String filePath = PLAYER_JSON_LOCATION + File.separator + countryId + PLAYER_STATS_FILE_JSON;
                sqliteJDBC.readJSON(filePath, countryId);
            }
            log.info("Row Count" + sqliteJDBC.getRowCount());
            //sqliteJDBC.selectRow();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void TestCreateTable() {
        SQLiteJDBC sqliteJDBC = new SQLiteJDBC();
        sqliteJDBC.createTable();
    }

    @Test
    public void TestDropTable() {
        SQLiteJDBC sqliteJDBC = new SQLiteJDBC();
        sqliteJDBC.dropTable();
    }
}

