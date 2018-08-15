package service;

import com.cricket.stats.dropbox.UploadToDropbox;

import org.junit.Test;

public class uploadToDropbox {

    @Test
    public void testPlayerMV() {

        UploadToDropbox uploadToDropbox = new UploadToDropbox();
        uploadToDropbox.main();

    }
}
