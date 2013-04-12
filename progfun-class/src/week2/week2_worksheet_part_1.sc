object week2_worksheet {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet

  def sum(f: Int => Int, a: Int, b: Int): Int = {
    def loop(a: Int, acc: Int): Int = {
      if (a > b) acc
      else loop(a + 1, f(a) + acc)
    }
    loop(a, 0)
  }                                               //> sum: (f: Int => Int, a: Int, b: Int)Int
  sum(x => x * x, 3, 5)                           //> res0: Int = 50

  def sumCurry(f: Int => Int): (Int, Int) => Int = {
    def sumF(a: Int, b: Int): Int =
      if (a > b) 0
      else f(a) + sumF(a + 1, b)
    sumF
  }                                               //> sumCurry: (f: Int => Int)(Int, Int) => Int
  sumCurry(x => x * x)(3, 5)                      //> res1: Int = 50

  def product(f: Int => Int)(a: Int, b: Int): Int = {
    if (a > b) 1
    else f(a) * product(f)(a + 1, b)
  }                                               //> product: (f: Int => Int)(a: Int, b: Int)Int
  product(x => x * x)(3, 4)                       //> res2: Int = 144

  def fact(n: Int) = product(x => x)(1, n)        //> fact: (n: Int)Int
  fact(5)                                         //> res3: Int = 120

  def mapReduce(f: Int => Int, combine: (Int, Int) => Int, zero: Int)(a: Int, b: Int): Int =
    if (a > b) zero
    else combine(f(a), mapReduce(f, combine, zero)(a + 1, b))
                                                  //> mapReduce: (f: Int => Int, combine: (Int, Int) => Int, zero: Int)(a: Int, b:
                                                  //|  Int)Int

  def productMR(f: Int => Int)(a: Int, b: Int): Int = mapReduce(f, (x, y) => x * y, 1)(a, b)
                                                  //> productMR: (f: Int => Int)(a: Int, b: Int)Int
  productMR(x => x * x)(3, 4)                     //> res4: Int = 144

  def factMR(n: Int) = productMR(x => x)(1, n)    //> factMR: (n: Int)Int
  factMR(5)                                       //> res5: Int = 120

  import math.abs

  val tolerance = 0.0001                          //> tolerance  : Double = 1.0E-4
  def isCloseEnough(x: Double, y: Double) =
    abs((x - y) / x) / x < tolerance              //> isCloseEnough: (x: Double, y: Double)Boolean
  def fixedPoint(f: Double => Double)(firstGuess: Double) = {
    def iterate(guess: Double): Double = {
      //println("guess = " +guess)
      val next = f(guess)
      if (isCloseEnough(guess, next)) next
      else iterate(next)
    }
    iterate(firstGuess)
  }                                               //> fixedPoint: (f: Double => Double)(firstGuess: Double)Double
  fixedPoint(x => 1 + x / 2)(1)                   //> res6: Double = 1.999755859375
  def sqrt(x: Double) = fixedPoint(y => (y + x / y) / 2)(1)
                                                  //> sqrt: (x: Double)Double
  sqrt(2)                                         //> res7: Double = 1.4142135623746899

  def averageDamp(f: Double => Double)(x: Double) = (x + f(x)) / 2
                                                  //> averageDamp: (f: Double => Double)(x: Double)Double
  def sqrt2(x: Double) =
    fixedPoint(averageDamp(y => x / y))(1)        //> sqrt2: (x: Double)Double
  sqrt2(2)                                        //> res8: Double = 1.4142135623746899
}