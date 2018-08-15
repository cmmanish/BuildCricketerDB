package com.cricket.stats.tests;

import org.junit.Test;

/**
 * Created by mmadhusoodan on 8/28/15.
 */
public class HelloJava {

    @Test
    public void Hello() {

        String cbURL = "http://www.cricbuzz.com/profiles/7952/";
        int len = cbURL.length();
        String id = cbURL.substring(33, len - 1);
        System.out.println(id);

    }
}