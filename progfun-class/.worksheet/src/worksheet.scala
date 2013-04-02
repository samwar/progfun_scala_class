object worksheet {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(85); 

  def and(x: Boolean, y: Boolean) = {
    if (x) y else false
  };System.out.println("""and: (x: Boolean, y: Boolean)Boolean""");$skip(68); 

  def or(x: Boolean, y: => Boolean) = {
    if (x) true else y
  };System.out.println("""or: (x: Boolean, y: => Boolean)Boolean""");$skip(358); 

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

  };System.out.println("""sqrt: (x: Double)Double""");$skip(10); val res$0 = 
  sqrt(2);System.out.println("""res0: Double = """ + $show(res$0));$skip(10); val res$1 = 
  sqrt(4);System.out.println("""res1: Double = """ + $show(res$1));$skip(8); val res$2 = 
  1 - 2;System.out.println("""res2: Int(-1) = """ + $show(res$2));$skip(213); 
  
  def sum(xs: List[Int]): Int = {
    def summer(count: Int, remainder: List[Int]): Int = {
      if(remainder.isEmpty) count
      else summer(count+remainder.head, remainder.tail)
    }
    summer(0, xs)
  };System.out.println("""sum: (xs: List[Int])Int""");$skip(26); val res$3 = 
  
  sum(List(1,2,3,5,6));System.out.println("""res3: Int = """ + $show(res$3));$skip(305); 
  
  def max(xs: List[Int]): Int = {
    def findMax(max:Int, remainingNums: List[Int]): Int = {
      if(remainingNums.isEmpty) max
      else if(max < remainingNums.head) findMax(remainingNums.head, remainingNums.tail)
      else findMax(max, remainingNums.tail)
    }
    findMax(xs.head, xs.tail)
  };System.out.println("""max: (xs: List[Int])Int""");$skip(22); val res$4 = 
  
  max(List(1,2,3));System.out.println("""res4: Int = """ + $show(res$4));$skip(29); val res$5 = 
  max(List(1,2,3,6,7,8,100));System.out.println("""res5: Int = """ + $show(res$5));$skip(19); val res$6 = 
  max(List(3,5,1));System.out.println("""res6: Int = """ + $show(res$6))}
}

  