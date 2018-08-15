package com.cricket.stats.dropbox;

import com.cricket.stats.utils.QaProperties;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.v2.DbxClientV2;
import com.dropbox.core.v2.DbxFiles;
import com.dropbox.core.v2.DbxUsers;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.logging.Logger;

public class UploadToDropbox {

    public static Logger log = Logger.getLogger(String.valueOf(UploadToDropbox.class));
    static String ACCESS_TOKEN = "";

    public UploadToDropbox() {
        ACCESS_TOKEN = QaProperties.getProperty().getProperty("access_token");
    }

    public void main() {
        try {
            DbxRequestConfig config = new DbxRequestConfig("dropbox/java-tutorial", "en_US");
            DbxClientV2 client = new DbxClientV2(config, ACCESS_TOKEN);
            DbxUsers.FullAccount account = client.users.getCurrentAccount();
            InputStream in = new FileInputStream("src/main/resources/CRICKET.db");
            DbxFiles.FileMetadata metadata = client.files.uploadBuilder("/database/CRICKET.db").run(in);

            log.info(account.email);
            log.info(metadata.size + " Bytes CRICKET.db Uploaded ");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}