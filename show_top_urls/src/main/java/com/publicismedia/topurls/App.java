package com.publicismedia.topurls;


public class App {
    public static void main(String[] args) {
        UrlAnalyzer urlAnalyzer = new UrlAnalyzerImpl();
        String[] impUrls = urlAnalyzer.topUrlsWithHighestImpressionCount(100);
        String[] oldUrls = urlAnalyzer.topUrlsWithOlderUnixTs(100);
        for (String url : impUrls){ System.out.println(url); }
        for (String url : oldUrls){ System.out.println(url); }
    }
}
