package objsets

import org.scalatest.FunSuite

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class TweetSetSuite extends FunSuite {
  trait TestSets {
    val allTweets = TweetReader.allTweets
    val retweets321 = allTweets.filter(elem => elem.retweets == 321)
    val retweets15 = allTweets.filter(elem => elem.retweets == 15)
    
    val set0 = new Empty
    //    val set1 = new NonEmpty(new Tweet("a", "b body", 1), new Empty, new Empty)
    //    val set1a = new NonEmpty(new Tweet("b", "a body", 1), set1, new Empty)
    //    val set2 = set1a.incl(new Tweet("c", "c body", 7))
    //    val set3 = set2.incl(new Tweet("d", "d body", 20))
    //    val c = new Tweet("e", "e body", 20)
    //    val d = new Tweet("f", "f body", 9)
    val set1 = new Empty
    val set2 = set1.incl(new Tweet("a", "a body", 20))
    val set3 = set2.incl(new Tweet("b", "b body", 20))
    val c = new Tweet("c", "c body", 7)
    val d = new Tweet("d", "d body", 9)
    val set4c = set3.incl(c)
    val set4d = set3.incl(d)
    val set5 = set4c.incl(d)
  }

  def asSet(tweets: TweetSet): Set[Tweet] = {
    var res = Set[Tweet]()
    tweets.foreach(res += _)
    res
  }

  def size(set: TweetSet): Int = asSet(set).size

  test("filter speed") {
    new TestSets {
      //println(retweets321.toString())
      assert(size(retweets321) === 1)
    }
  }

  test("union speed") {
    new TestSets {
      //println((retweets321 union retweets15).toString)
      //println(size(retweets15))
      assert(size((retweets321 union retweets15) filter (elem => elem.retweets == 321)) === 1)
      assert(size(retweets321.union(retweets15)) === 18)
    }
  }

  test("filter: on empty set") {
    new TestSets {
      assert(size(set0.filter(tw => tw.user == "a")) === 0)
    }
  }

  test("filter: a on set5") {
    new TestSets {
      assert(size(set5.filter(tw => tw.user == "a")) === 1)
    }
  }

  test("filter: g on set5") {
    new TestSets {
      assert(size(set5.filter(tw => tw.user == "g")) === 0)
    }
  }

  test("filter: <= 9 on set5") {
    new TestSets {
      //println(set5.toString())
      assert(size(set5.filter(tw => tw.retweets <= 9)) === 2)
    }
  }

  test("filter: 20 on set5") {
    new TestSets {
      //println(set5.toString())
      assert(size(set5.filter(tw => tw.retweets == 20)) === 2)
    }
  }

  test("filter: 10 on set5") {
    new TestSets {
      //println(set5.toString())
      assert(size(set5.filter(tw => tw.retweets == 10)) === 0)
    }
  }

  test("union: set4c and set4d") {
    new TestSets {
      assert(size(set4c.union(set4d)) === 4)
    }
  }

  test("union: with empty set (1)") {
    new TestSets {
      assert(size(set5.union(set0)) === 4)
    }
  }

  test("union: with empty set (2)") {
    new TestSets {
      assert(size(set0.union(set5)) === 4)
    }
  }
  
  test("filter and most retweeted gizmodo tweets") {
    new TestSets{
      val gizmodoTweets = TweetReader.toTweetSet(TweetReader.tweetMap.get(TweetReader.sites(0)).get)
      //println(gizmodoTweets)
      assert(size(gizmodoTweets filter (elem => elem.retweets == 15)) ===2)
      assert(gizmodoTweets.mostRetweeted.retweets ===321)      
    }
  }

  
//    test("union: gizmodo and amazon Tweets") {
//    	println(TweetReader.allTweets)
//    }

  test("descending: set5") {
    new TestSets {
      val trends = set5.descendingByRetweet
      assert(!trends.isEmpty)
      assert(trends.head.user == "a" || trends.head.user == "b")
    }
  }
  
   test("trending: google and apple tweets") {
    new TestSets {
      val trends = GoogleVsApple.trending
      assert(!trends.isEmpty)
    }
  }
}
