object worksheet {
  def pascal(c: Int, r: Int): Int = {
    def factorial(x: Int, Accum: Int): Int = if (x == 0) Accum else factorial(x - 1, x * Accum)
    factorial(r, 1) / (factorial(r - c, 1) * factorial(c, 1))
  }                                               //> pascal: (c: Int, r: Int)Int

  def and(x: Boolean, y: Boolean) = {
    if (x) y else false
  }                                               //> and: (x: Boolean, y: Boolean)Boolean

  def or(x: Boolean, y: => Boolean) = {
    if (x) true else y
  }                                               //> or: (x: Boolean, y: => Boolean)Boolean

  def abs(x: Double) = if (x >= 0) x else -x      //> abs: (x: Double)Double

  def sqrt(x: Double) = {

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
}

  