package week6

object week6_worksheet_sets {
  val fruit = Set("apple", "banana", "pear")      //> fruit  : scala.collection.immutable.Set[String] = Set(apple, banana, pear)
  val s = (1 to 6).toSet                          //> s  : scala.collection.immutable.Set[Int] = Set(5, 1, 6, 2, 3, 4)

  s map (_ + 2)                                   //> res0: scala.collection.immutable.Set[Int] = Set(5, 6, 7, 3, 8, 4)
  fruit filter (_.startsWith("app"))              //> res1: scala.collection.immutable.Set[String] = Set(apple)
  s.nonEmpty                                      //> res2: Boolean = true

  //Differences between sets and sequences:
  // 1. Sets are unordered; the elements of a set do not have a predefined order in which they appear in the set
  // 2. sets do not have duplicate elements:
  s map (_ / 2)                                   //> res3: scala.collection.immutable.Set[Int] = Set(2, 0, 3, 1)
  // 3. The fundamental operation on sets is contains:
  s contains 5                                    //> res4: Boolean = true
  
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
  }                                               //> queens: (n: Int)Set[List[Int]]
  
  def isSafe(col:Int, queens:List[Int]):Boolean = {
  	val row = queens.length
  	val queensWithRow = (row -1 to 0 by -1) zip queens
  	queensWithRow forall {
  		case(r, c) => col != c && math.abs(col -c) != row - r
  	}
  }                                               //> isSafe: (col: Int, queens: List[Int])Boolean
  def show(queens: List[Int]) ={
  	val lines =
  		for(col <- queens.reverse)
  		yield Vector.fill(queens.length)("* ").updated(col, "X ").mkString
  		"\n" + (lines mkString "\n")
  }                                               //> show: (queens: List[Int])String
  
  (queens(8) take 3 map show) mkString "\n"       //> res5: String = "
                                                  //| * * * * * X * * 
                                                  //| * * * X * * * * 
                                                  //| * X * * * * * * 
                                                  //| * * * * * * * X 
                                                  //| * * * * X * * * 
                                                  //| * * * * * * X * 
                                                  //| X * * * * * * * 
                                                  //| * * X * * * * * 
                                                  //| 
                                                  //| * * * * X * * * 
                                                  //| * * * * * * X * 
                                                  //| * X * * * * * * 
                                                  //| * * * X * * * * 
                                                  //| * * * * * * * X 
                                                  //| X * * * * * * * 
                                                  //| * * X * * * * * 
                                                  //| * * * * * X * * 
                                                  //| 
                                                  //| * * * * * X * * 
                                                  //| * * X * * * * * 
                                                  //| * * * * * * X * 
                                                  //| * * * X * * * * 
                                                  //| X * * * * * * * 
                                                  //| * * * * * * * X 
                                                  //| * X * * * * * * 
                                                  //| * * * * X * * * "
}