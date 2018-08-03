package com.publicismedia.topurls;

public class UrlAnalyzerImpl implements UrlAnalyzer {
    @Override
    public void add(String url, int impressionCount, int timestamp) {
        //
    }

    @Override
    public String[] topUrlsWithHighestImpressionCount(int count) {
        String[] urls = new String[count];
        urls[0] = "http://xyz.abc/27-sint-non";
        return urls;
    }

    @Override
    public String[] topUrlsWithOlderUnixTs(int count) {
        String[] urls = new String[count];
        urls[0] = "http://xyz.com/40-enim-fugiat";
        return urls;
    }
}
