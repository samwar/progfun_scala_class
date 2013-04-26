package week4

object week4_worksheet {
  List(1)                                         //> res0: week4.List[Int] = week4.Cons@23597cac
  List(1, 2)                                      //> res1: week4.List[Int] = week4.Cons@1899de83

  /**trait Expr {
    def isNumber: Boolean
    def isSum: Boolean
    def numValue: Int
    def leftOp: Expr
    def rightOp: Expr
  }
  
  class Number(n: Int) extends Expr {
    def isNumber: Boolean = true
    def isSum: Boolean = false
    def numValue: Int = n
    def leftOp: Expr = throw new Error("Number.leftOp")
    def rightOp: Expr = throw new Error("Number.rightOp")
  }
  
  class Sum(e1: Expr, e2: Expr) extends Expr {
    def isNumber: Boolean = false
    def isSum: Boolean = true
    def numValue: Int = throw new Error("Sum.numValue")
    def leftOp: Expr = e1
    def rightOp: Expr = e2
  }
}

object exprs {**/
	
	def show(e:Expr):String = e match {
		case Number(x) => x.toString
		case Sum(l, r) => show(l) + " + " + show(r)
		case Prod(y, z) => wrapParensMaybe(y) + " * " + wrapParensMaybe(z)
		case Var(v) => v
	}                                         //> show: (e: week4.Expr)String
	
	def wrapParensMaybe(e: Expr): String = e match {
    case Sum(_, _) => "(" ++ show(e) ++ ")"
    case _ => show(e)
  }                                               //> wrapParensMaybe: (e: week4.Expr)String
	
	show(Sum(Number(1), Number(44)))          //> res2: String = 1 + 44
	show(Var("x"))                            //> res3: String = x
	show(Sum(Prod(Number(2), Var("x")), Var("y")))
                                                  //> res4: String = 2 * x + y
	show(Prod(Sum(Number(2), Var("x")), Var("y")))
                                                  //> res5: String = (2 + x) * y
                                                  


	
}