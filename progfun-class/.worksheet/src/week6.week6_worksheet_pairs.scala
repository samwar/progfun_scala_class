package week6

object week6_worksheet_pairs {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(110); 
  def isPrime(n: Int): Boolean = (2 until n) forall (n % _ != 0);System.out.println("""isPrime: (n: Int)Boolean""");$skip(13); 

  val n = 7;System.out.println("""n  : Int = """ + $show(n ));$skip(240); val res$0 = 

  // Given a positive integer n, find all pairs of positive integers i and j,
  // with 1 <= j < i < n such that i + j is prime
  (1 until n) flatMap (i =>
    (1 until i) map (j => (i, j))) filter (pair =>
    isPrime(pair._1 + pair._2));System.out.println("""res0: scala.collection.immutable.IndexedSeq[(Int, Int)] = """ + $show(res$0));$skip(99); val res$1 = 
	//Using for-expressions
	for{
		i <- 1 until n
		j <- 1 until i
		if isPrime(i +j)
	} yield (i,j);System.out.println("""res1: scala.collection.immutable.IndexedSeq[(Int, Int)] = """ + $show(res$1));$skip(166); 
                                                  
   def scalarProduct(xs: List[Double], ys: List[Double]) : Double =
    (for ((x,y) <- xs zip ys) yield x * y).sum;System.out.println("""scalarProduct: (xs: List[Double], ys: List[Double])Double""")}
}
