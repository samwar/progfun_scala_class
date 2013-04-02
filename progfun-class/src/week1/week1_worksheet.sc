object worksheet {

  def and(x: Boolean, y: Boolean) = {
    if (x) y else false
  }                                               //> and: (x: Boolean, y: Boolean)Boolean

  def or(x: Boolean, y: => Boolean) = {
    if (x) true else y
  }                                               //> or: (x: Boolean, y: => Boolean)Boolean

  def sqrt(x: Double) = {
    def abs(x: Double) = if (x >= 0) x else -x

    def sqrtIter(guess: Double): Double =
      if (isGoodEnough(guess)) guess
      else sqrtIter(improve(guess))

    def isGoodEnough(guess: Double) =
      abs(guess * guess - x) / x < 0.001

    def improve(guess: Double) =
      (guess + x / guess) / 2

    sqrtIter(1.0)

  }                                               //> sqrt: (x: Double)Double
  sqrt(2)                                         //> res0: Double = 1.4142156862745097
  sqrt(4)                                         //> res1: Double = 2.000609756097561
  1 - 2                                           //> res2: Int(-1) = -1
  
  def sum(xs: List[Int]): Int = {
    def summer(count: Int, remainder: List[Int]): Int = {
      if(remainder.isEmpty) count
      else summer(count+remainder.head, remainder.tail)
    }
    summer(0, xs)
  }                                               //> sum: (xs: List[Int])Int
  
  sum(List(1,2,3,5,6))                            //> res3: Int = 17
  
  def max(xs: List[Int]): Int = {
    def findMax(max:Int, remainingNums: List[Int]): Int = {
      if(remainingNums.isEmpty) max
      else if(max < remainingNums.head) findMax(remainingNums.head, remainingNums.tail)
      else findMax(max, remainingNums.tail)
    }
    findMax(xs.head, xs.tail)
  }                                               //> max: (xs: List[Int])Int
  
  max(List(1,2,3))                                //> res4: Int = 3
  max(List(1,2,3,6,7,8,100))                      //> res5: Int = 100
  max(List(3,5,1))                                //> res6: Int = 5
}

  