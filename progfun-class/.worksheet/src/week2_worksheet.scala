object week2_worksheet {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(68); 
  println("Welcome to the Scala worksheet");$skip(172); 

  def sum(f: Int => Int, a: Int, b: Int): Int = {
    def loop(a: Int, acc: Int): Int = {
      if (a > b) acc
      else loop(a + 1, f(a) + acc)
    }
    loop(a, 0)
  };System.out.println("""sum: (f: Int => Int, a: Int, b: Int)Int""");$skip(24); val res$0 = 
  sum(x => x * x, 3, 5);System.out.println("""res0: Int = """ + $show(res$0));$skip(155); 

  def sumCurry(f: Int => Int): (Int, Int) => Int = {
    def sumF(a: Int, b: Int): Int =
      if (a > b) 0
      else f(a) + sumF(a + 1, b)
    sumF
  };System.out.println("""sumCurry: (f: Int => Int)(Int, Int) => Int""");$skip(29); val res$1 = 
  sumCurry(x => x * x)(3, 5);System.out.println("""res1: Int = """ + $show(res$1));$skip(113); 

  def product(f: Int => Int)(a: Int, b: Int): Int = {
    if (a > b) 1
    else f(a) * product(f)(a + 1, b)
  };System.out.println("""product: (f: Int => Int)(a: Int, b: Int)Int""");$skip(28); val res$2 = 
  product(x => x * x)(3, 4);System.out.println("""res2: Int = """ + $show(res$2));$skip(44); 

  def fact(n: Int) = product(x => x)(1, n);System.out.println("""fact: (n: Int)Int""");$skip(10); val res$3 = 
  fact(5);System.out.println("""res3: Int = """ + $show(res$3));$skip(176); 

  def mapReduce(f: Int => Int, combine: (Int, Int) => Int, zero: Int)(a: Int, b: Int): Int =
    if (a > b) zero
    else combine(f(a), mapReduce(f, combine, zero)(a + 1, b));System.out.println("""mapReduce: (f: Int => Int, combine: (Int, Int) => Int, zero: Int)(a: Int, b: Int)Int""");$skip(94); 

  def productMR(f: Int => Int)(a: Int, b: Int): Int = mapReduce(f, (x, y) => x * y, 1)(a, b);System.out.println("""productMR: (f: Int => Int)(a: Int, b: Int)Int""");$skip(30); val res$4 = 
  productMR(x => x * x)(3, 4);System.out.println("""res4: Int = """ + $show(res$4));$skip(48); 

  def factMR(n: Int) = productMR(x => x)(1, n);System.out.println("""factMR: (n: Int)Int""");$skip(12); val res$5 = 
  factMR(5)

  import math.abs;System.out.println("""res5: Int = """ + $show(res$5));$skip(45); 

  val tolerance = 0.0001;System.out.println("""tolerance  : Double = """ + $show(tolerance ));$skip(81); 
  def isCloseEnough(x: Double, y: Double) =
    abs((x - y) / x) / x < tolerance;System.out.println("""isCloseEnough: (x: Double, y: Double)Boolean""");$skip(268); 
  def fixedPoint(f: Double => Double)(firstGuess: Double) = {
    def iterate(guess: Double): Double = {
      //println("guess = " +guess)
      val next = f(guess)
      if (isCloseEnough(guess, next)) next
      else iterate(next)
    }
    iterate(firstGuess)
  };System.out.println("""fixedPoint: (f: Double => Double)(firstGuess: Double)Double""");$skip(32); val res$6 = 
  fixedPoint(x => 1 + x / 2)(1);System.out.println("""res6: Double = """ + $show(res$6));$skip(60); 
  def sqrt(x: Double) = fixedPoint(y => (y + x / y) / 2)(1);System.out.println("""sqrt: (x: Double)Double""");$skip(10); val res$7 = 
  sqrt(2);System.out.println("""res7: Double = """ + $show(res$7));$skip(68); 

  def averageDamp(f: Double => Double)(x: Double) = (x + f(x)) / 2;System.out.println("""averageDamp: (f: Double => Double)(x: Double)Double""");$skip(68); 
  def sqrt2(x: Double) =
    fixedPoint(averageDamp(y => x / y))(1);System.out.println("""sqrt2: (x: Double)Double""");$skip(11); val res$8 = 
  sqrt2(2);System.out.println("""res8: Double = """ + $show(res$8))}
}
