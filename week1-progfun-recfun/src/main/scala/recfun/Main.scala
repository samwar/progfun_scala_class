package recfun
import common._

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int = {
    def factorial(n: Int): Int = {
      def loop(acc: Int, n: Int): Int =
        if (n == 0) acc
        else loop(acc * n, n - 1)
      loop(1, n)
    }
    factorial(r) / (factorial(r - c) * factorial(c))
  }
  
//  def pascal(c: Int, r: Int): Int = {
//    def fact(c: Int): Int = if (c == 0) 1 else c * fact(c-1)
//
//    fact(r) / (fact(r-c) * fact(c))
//  }

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {
    def stringBalanced(chars: List[Char], openCount: Int): Boolean = {
      if (chars.isEmpty) openCount == 0
      else if ('(' == chars.head) stringBalanced(chars.tail, openCount + 1)
      else if (')' == chars.head) openCount > 0 && stringBalanced(chars.tail, openCount - 1)
      else stringBalanced(chars.tail, openCount)
    }
    stringBalanced(chars, 0)
  }

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = {
    def changeCounter(denominations: List[Int], moneyRemaining: Int, count: Int): Int = {
      if (denominations.isEmpty || moneyRemaining < 0) 0
      else if (moneyRemaining == 0) count + 1
      else changeCounter(denominations.tail, moneyRemaining, count) + changeCounter(denominations, moneyRemaining - denominations.head, count)
    }
    changeCounter(coins, money, 0)
  }

}
