package com.cricket.stats.util;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by mmadhusoodan on 2/11/16.
 */

public class GetURLContent {
    public static void main(String[] args) {

        URL url;

        String myURL = "http://hmkcode.com/examples/index.php";
        try {
            // get URL content
            url = new URL(myURL);
            URLConnection conn = url.openConnection();

            // open the stream and put it into BufferedReader
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            System.out.println(br.readLine());

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}