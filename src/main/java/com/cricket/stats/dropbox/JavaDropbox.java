package com.cricket.stats.dropbox;

import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.v2.DbxClientV2;
import com.dropbox.core.v2.DbxFiles;
import com.dropbox.core.v2.DbxUsers;
import org.apache.log4j.Logger;

import java.io.FileInputStream;
import java.io.InputStream;

public class JavaDropbox {

    public static Logger log = Logger.getLogger(JavaDropbox.class);
    static final String ACCESS_TOKEN = "vLcLAbtJ96oAAAAAAAABRKq67S1P6DO4RUxkdzAyYiXzBEKn9Hrkna_Qr_-VELFc";

    public static void main(String args[]) {

        String address = "src/main/resources/local.properties";
        try {
            DbxRequestConfig config = new DbxRequestConfig("dropbox/java-tutorial", "en_US");
            DbxClientV2 client = new DbxClientV2(config, ACCESS_TOKEN);
            DbxUsers.FullAccount account = client.users.getCurrentAccount();
            InputStream in = new FileInputStream("src/main/resources/CRICKET.db");
            DbxFiles.FileMetadata metadata = client.files.uploadBuilder("/database/CRICKET.db").run(in);

            log.info("CRICKET.db Uploaded Size: " + metadata.size);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}