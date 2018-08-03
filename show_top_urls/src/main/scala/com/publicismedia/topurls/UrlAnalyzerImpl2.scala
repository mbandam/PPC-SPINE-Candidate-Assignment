package com.publicismedia.topurls

class UrlAnalyzerImpl2 extends UrlAnalyzer {
  override def add(url: String, impressionCount: Int, timestamp: Int) = {

  }

  override def topUrlsWithHighestImpressionCount(n: Int): Array[String] = {
    Array.empty
  }

  override def topUrlsWithOlderUnixTs(n: Int): Array[String] = {
    Array.empty
  }
}
