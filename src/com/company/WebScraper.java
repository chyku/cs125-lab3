package com.company;

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class WebScraper {

    /**
     * Retrieve contents from a URL and return them as a string.
     *
     * @param url url to retrieve contents from
     * @return the contents from the url as a string, or an empty string on error
     */
    public static String urlToString(final String url) {
        Scanner urlScanner;
        try {
            urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
        } catch (IOException e) {
            return "";
        }
        String contents = urlScanner.useDelimiter("\\A").next();
        urlScanner.close();
        return contents;
    }

    public static void main(String[] args) {
        String[] urls = {"http://erdani.com/tdpl/hamlet.txt", "https://www.bls.gov/tus/charts/chart9.txt",  "http://tgftp.nws.noaa.gov/data/raw/fz/fzus53.klot.srf.lot.txt"};
        for (int i = 0; i < urls.length; i++) {
            String test = urlToString(urls[i]);
            String[] arr = test.split(" ");
            System.out.println(arr.length);
        }
    }
}
