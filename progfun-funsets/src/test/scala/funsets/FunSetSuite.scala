package funsets

import org.scalatest.FunSuite

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

/**
 * This class is a test suite for the methods in object FunSets. To run
 * the test suite, you can either:
 *  - run the "test" command in the SBT console
 *  - right-click the file in eclipse and chose "Run As" - "JUnit Test"
 */
@RunWith(classOf[JUnitRunner])
class FunSetSuite extends FunSuite {

  /**
   * Link to the scaladoc - very clear and detailed tutorial of FunSuite
   *
   * http://doc.scalatest.org/1.9.1/index.html#org.scalatest.FunSuite
   *
   * Operators
   *  - test
   *  - ignore
   *  - pending
   */

  /**
   * Tests are written using the "test" operator and the "assert" method.
   */
  test("string take") {
    val message = "hello, world"
    assert(message.take(5) == "hello")
  }

  /**
   * For ScalaTest tests, there exists a special equality operator "===" that
   * can be used inside "assert". If the assertion fails, the two values will
   * be printed in the error message. Otherwise, when using "==", the test
   * error message will only say "assertion failed", without showing the values.
   *
   * Try it out! Change the values so that the assertion fails, and look at the
   * error message.
   */
  test("adding ints") {
    assert(1 + 2 === 3)
  }

  import FunSets._

  test("contains is implemented") {
    assert(contains(x => true, 100))
  }

  /**
   * When writing tests, one would often like to re-use certain values for multiple
   * tests. For instance, we would like to create an Int-set and have multiple test
   * about it.
   *
   * Instead of copy-pasting the code for creating the set into every test, we can
   * store it in the test class using a val:
   *
   *   val s1 = singletonSet(1)
   *
   * However, what happens if the method "singletonSet" has a bug and crashes? Then
   * the test methods are not even executed, because creating an instance of the
   * test class fails!
   *
   * Therefore, we put the shared values into a separate trait (traits are like
   * abstract classes), and create an instance inside each test method.
   *
   */

  trait TestSets {
    val s1 = singletonSet(1)
    val s2 = singletonSet(2)
    val s3 = singletonSet(3)
    val s4 = union(s1, s2)
    val s5 = union(s3, s4)
  }

  /**
   * This test is currently disabled (by using "ignore") because the method
   * "singletonSet" is not yet implemented and the test would fail.
   *
   * Once you finish your implementation of "singletonSet", exchange the
   * function "ignore" by "test".
   */
  test("singletonSet(1) contains 1") {

    /**
     * We create a new instance of the "TestSets" trait, this gives us access
     * to the values "s1" to "s3".
     */
    new TestSets {
      /**
       * The string argument of "assert" is a message that is printed in case
       * the test fails. This helps identifying which assertion failed.
       */
      assert(contains(s1, 1), "Singleton")
    }
  }

  test("union contains all elements") {
    new TestSets {
      val s = union(s1, s2)
      val t = union(s2, s3)
      val u = union(s, t)
      //printSet(u)
      assert(contains(s, 1), "Union 1")
      assert(contains(s, 2), "Union 2")
      assert(!contains(s, 3), "Union 3")
    }
  }

  test("intersect") {
    new TestSets {
      val set = union(s1, s2)
      val set1 = union(s2, s3)
      val set2 = intersect(set, set1)
      //      printSet(set)
      //      printSet(set1)
      //      printSet(set2)
      assert(contains(set2, 2), "Intersect 2")
      assert(!contains(set2, 1), "Intersect 1")
      assert(!contains(set2, 3), "Intersect 3")
    }
  }

  test("diff") {
    new TestSets {
      val s = union(s1, s2)
      val t = union(s2, s3)
      val u = union(s, t)
      val w = diff(s, t)
//      printSet(s)
//      printSet(t)
//      printSet(u)
//      printSet(w)
      assert(contains(w, 1), "Diff 1")
      assert(!contains(w, 2), "Diff 2")
      assert(!contains(w, 3), "Diff 3")
    }
  }

  test("filter will use predicate to every set") {
    new TestSets {
      val w = singletonSet(1)
      val x = singletonSet(2)
      val y = singletonSet(3)
      val z = singletonSet(-4)
      val a = union(w, x)
      val b = union(a, y)
      val c = union(b, z)
      //c = {1,2,3,-4} 
      val f = filter(c, x => (x < 0))
      //      printSet(f)
      // f = {1,2,3} 
      assert(!contains(f, 1), "f does not contain 1")
      assert(!contains(f, 2), "f does not contain 2")
      assert(!contains(f, 3), "f does not contain 3")
      assert(contains(f, -4), "f contains -4")
    }
  }

  test("forall") {

    new TestSets {

      // s1 = {1}, s2 = {2}, s3 = {3} as defined earlier in FunSetSuite

      // Every member of s1 satisfies the predicate x == 1
      assert(forall(s1, x => x == 1) === true, "is 1")

      // Not all members of s2 satisfy the predicate x == 1
      assert(forall(s2, x => x == 1) === false, "is not 1")

      // build s = s{1,2,3}
      val s = union(union(s1, s2), s3)

      // all members of s satisfy x > 0
      assert(forall(s, x => x > 0) === true, "positive")

      // not all members of s satisfy x < 2
      assert(forall(s, x => x < 2) === false, "less than 2")

      assert(true)
      assert(forall((a: Int) => (a <= 4), (a: Int) => (a <= 5)) === true)
      assert(forall(singletonSet(3), (a: Int) => (a <= 2)) === false)
      assert(forall(singletonSet(3), (a: Int) => (a >= 5)) === false)

    }
  }

  test("exists") {
    new TestSets {
      // build s = s{1,2,3}
      val s = union(union(s1, s2), s3)

      // all members of s satisfy x > 0
      assert(exists(s, x => x > 0) === true, "positive")

      // not all members of s satisfy x < 2
      assert(exists(s, x => x < 2) === true, "less than 2")
      assert(exists((a: Int) => (a <= 4), (a: Int) => (a <= 5)) === true)
      assert(exists(singletonSet(3), (a: Int) => (a <= 2)) === false)
      assert(exists(singletonSet(3), (a: Int) => (a >= 5)) === false)
    }
  }

  test("maps") {
   
    val m = map(singletonSet(3), (x: Int) => x * x)
    printSet(m)
    assert(contains(map(singletonSet(3), (x: Int) => x * x), 9) === true)
  }

}
