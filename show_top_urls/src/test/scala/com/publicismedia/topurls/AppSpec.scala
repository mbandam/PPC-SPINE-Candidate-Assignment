package com.publicismedia.topurls

import java.util.TimeZone
import org.scalatest._


class AppSpec extends FlatSpec with Matchers with BeforeAndAfter with BeforeAndAfterAll {

  def getResource(r: String): String = com.google.common.io.Resources.getResource(r).getPath

  override def beforeAll(): Unit = {
    super.beforeAll()
    TimeZone.setDefault(TimeZone.getTimeZone("UTC"))
  }

  override def afterAll(): Unit = {
    super.afterAll()
  }

  val examples = Seq(
    "http://example.com/141-et-ut,34152,1475524198",
    "http://example.com/276-nulla-ipsum,5566,1475524197",
    "http://xyz.com/40-enim-fugiat,42016,1475524195",
    "http://example.com/270-anim-laborum,5910,1475524198",
    "http://xyz.abc/27-sint-non,44190,1475524198"
  )

  "App" should "find highest impression count" in {
    val analyzer = new UrlAnalyzerImpl()
    analyzer.add("http://example.com/255-elit-ea", 22575, 1475524197)
    analyzer.add("http://example.com/276-nulla-ipsum", 5566, 1475524197)
    analyzer.add("http://xyz.com/40-enim-fugiat", 42016, 1475524195)
    analyzer.add("http://example.com/270-anim-laborum", 5910, 1475524198)
    analyzer.add("http://xyz.abc/27-sint-non", 44190, 1475524198)
    assert(analyzer.topUrlsWithHighestImpressionCount(1).toVector == Vector("http://xyz.abc/27-sint-non"))
  }

  it should "find oldest url" in {
    val analyzer = new UrlAnalyzerImpl()
    analyzer.add("http://example.com/255-elit-ea", 22575, 1475524197)
    analyzer.add("http://example.com/276-nulla-ipsum", 5566, 1475524197)
    analyzer.add("http://xyz.com/40-enim-fugiat", 42016, 1475524195)
    analyzer.add("http://example.com/270-anim-laborum", 5910, 1475524198)
    analyzer.add("http://xyz.abc/27-sint-non", 44190, 1475524198)
    assert(analyzer.topUrlsWithOlderUnixTs(1).toVector == Vector("http://xyz.com/40-enim-fugiat"))
  }

  it should "read top 100" in {
    val analyzer = new UrlAnalyzerImpl()
    val test: Iterator[Array[String]] = (0 to 4).iterator.flatMap{i =>
      scala.io.Source
        .fromFile(getResource(s"file$i.txt"))
        .getLines()
        .map(_.split(","))
    }
    test.foreach(a => analyzer.add(a(0), a(1).toInt, a(2).toInt))

    val answer: Vector[String] = scala.io.Source.fromFile(getResource("answer.lst")).getLines().toVector
    val oldest: Vector[String] = scala.io.Source.fromFile(getResource("oldest.lst")).getLines().toVector

    assert(analyzer.topUrlsWithHighestImpressionCount(100).toVector == answer)
    assert(analyzer.topUrlsWithOlderUnixTs(100).toVector == oldest)
  }

}

