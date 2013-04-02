object worksheet {import scala.runtime.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(218); 
  def pascal(c: Int, r: Int): Int = {
    def factorial(x: Int, Accum: Int): Int = if (x == 0) Accum else factorial(x - 1, x * Accum)
    factorial(r, 1) / (factorial(r - c, 1) * factorial(c, 1))
  };System.out.println("""pascal: (c: Int, r: Int)Int""");$skip(67); 

  def and(x: Boolean, y: Boolean) = {
    if (x) y else false
  };System.out.println("""and: (x: Boolean, y: Boolean)Boolean""");$skip(68); 

  def or(x: Boolean, y: => Boolean) = {
    if (x) true else y
  };System.out.println("""or: (x: Boolean, y: => Boolean)Boolean""");$skip(46); 

  def abs(x: Double) = if (x >= 0) x else -x;System.out.println("""abs: (x: Double)Double""");$skip(311); 

  def sqrt(x: Double) = {

    def sqrtIter(guess: Double): Double =
      if (isGoodEnough(guess)) guess
      else sqrtIter(improve(guess))

    def isGoodEnough(guess: Double) =
      abs(guess * guess - x) / x < 0.001

    def improve(guess: Double) =
      (guess + x / guess) / 2

    sqrtIter(1.0)

  };System.out.println("""sqrt: (x: Double)Double""");$skip(10); val res$0 = 
  sqrt(2);System.out.println("""res0: Double = """ + $show(res$0));$skip(10); val res$1 = 
  sqrt(4);System.out.println("""res1: Double = """ + $show(res$1));$skip(8); val res$2 = 
  1 - 2;System.out.println("""res2: Int(-1) = """ + $show(res$2))}
}

  