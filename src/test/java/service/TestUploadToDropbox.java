package service;


import com.cricket.stats.dropbox.DropboxAPI;
import org.junit.Test;

public class TestUploadToDropbox {

    @Test
    public void uploadNow() {

        DropboxAPI dropboxAPI = new DropboxAPI();
        dropboxAPI.upload();

    }
}
