package com.publicismedia.topurls;

public interface UrlAnalyzer {

    /** Add impressionCount for url
     *
     * @param url
     * @param impressionCount
     * @param timestamp
     */
    void add(String url, int impressionCount, int timestamp);

    /** Shows top n URLs with highest impression count
     *
     * @param n number of files to show
     */
    String[] topUrlsWithHighestImpressionCount(int n);

    /** Shows top n URLs with oldest unix timestamps
     *
     * @param n
     */
    String[] topUrlsWithOlderUnixTs(int n);
}
