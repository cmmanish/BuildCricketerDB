package com.cricket.stats.dropbox;

import com.cricket.stats.utils.QaProperties;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.v2.DbxClientV2;
import com.dropbox.core.v2.DbxFiles;
import com.dropbox.core.v2.DbxUsers;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.logging.Logger;

import static com.cricket.stats.utils.QaConstants.CRICKET_DATABASE_LOCATION;

public class DropboxAPI {

    public static Logger log = Logger.getLogger(String.valueOf(DropboxAPI.class));
    static String access_token = "";

    public DropboxAPI() {
        access_token = QaProperties.getProperty().getProperty("access_token");
    }

    public void upload() {
        try {

            DbxRequestConfig config = new DbxRequestConfig("dropbox/java-tutorial", "en_US");
            DbxClientV2 client = new DbxClientV2(config, access_token);
            DbxUsers.FullAccount account = client.users.getCurrentAccount();
            InputStream in = new FileInputStream(CRICKET_DATABASE_LOCATION);
            DbxFiles.FileMetadata metadata = client.files.uploadBuilder("/database/CRICKET.db").run(in);

            log.info(account.email);
            log.info(metadata.size + " Bytes CRICKET.db Uploaded to Dropbox");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}