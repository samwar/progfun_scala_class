package week6

object week6_worksheet_sets {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(89); 
  val fruit = Set("apple", "banana", "pear");System.out.println("""fruit  : scala.collection.immutable.Set[String] = """ + $show(fruit ));$skip(25); 
  val s = (1 to 6).toSet;System.out.println("""s  : scala.collection.immutable.Set[Int] = """ + $show(s ));$skip(17); val res$0 = 

  s map (_ + 2);System.out.println("""res0: scala.collection.immutable.Set[Int] = """ + $show(res$0));$skip(37); val res$1 = 
  fruit filter (_.startsWith("app"));System.out.println("""res1: scala.collection.immutable.Set[String] = """ + $show(res$1));$skip(13); val res$2 = 
  s.nonEmpty;System.out.println("""res2: Boolean = """ + $show(res$2));$skip(219); val res$3 = 

  //Differences between sets and sequences:
  // 1. Sets are unordered; the elements of a set do not have a predefined order in which they appear in the set
  // 2. sets do not have duplicate elements:
  s map (_ / 2);System.out.println("""res3: scala.collection.immutable.Set[Int] = """ + $show(res$3));$skip(70); val res$4 = 
  // 3. The fundamental operation on sets is contains:
  s contains 5;System.out.println("""res4: Boolean = """ + $show(res$4));$skip(459); 
  
  // The eight queens problem - place eight queens on a chessboard such that no queen is threatened by another
  // In other words, there can't be two queens in the same row, column, or diagonal
  def queens(n: Int): Set[List[Int]] = {
  	def placeQueens(k:Int) :Set[List[Int]] =
  		if(k == 0) Set(List())
  		else
				for {
					queens <- placeQueens(k-1)
					col <- 0 until n
					if isSafe(col, queens)
				} yield col :: queens
  	placeQueens(n)
  };System.out.println("""queens: (n: Int)Set[List[Int]]""");$skip(229); 
  
  def isSafe(col:Int, queens:List[Int]):Boolean = {
  	val row = queens.length
  	val queensWithRow = (row -1 to 0 by -1) zip queens
  	queensWithRow forall {
  		case(r, c) => col != c && math.abs(col -c) != row - r
  	}
  };System.out.println("""isSafe: (col: Int, queens: List[Int])Boolean""");$skip(187); 
  def show(queens: List[Int]) ={
  	val lines =
  		for(col <- queens.reverse)
  		yield Vector.fill(queens.length)("* ").updated(col, "X ").mkString
  		"\n" + (lines mkString "\n")
  };System.out.println("""show: (queens: List[Int])String""");$skip(47); val res$5 = 
  
  (queens(8) take 3 map show) mkString "\n";System.out.println("""res5: String = """ + $show(res$5))}
}
