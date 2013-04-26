package week4

object week4_worksheet {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(49); val res$0 = 
  List(1);System.out.println("""res0: week4.List[Int] = """ + $show(res$0));$skip(13); val res$1 = 
  List(1, 2);System.out.println("""res1: week4.List[Int] = """ + $show(res$1));$skip(841); 

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
	};System.out.println("""show: (e: week4.Expr)String""");$skip(122); 
	
	def wrapParensMaybe(e: Expr): String = e match {
    case Sum(_, _) => "(" ++ show(e) ++ ")"
    case _ => show(e)
  };System.out.println("""wrapParensMaybe: (e: week4.Expr)String""");$skip(36); val res$2 = 
	
	show(Sum(Number(1), Number(44)));System.out.println("""res2: String = """ + $show(res$2));$skip(16); val res$3 = 
	show(Var("x"));System.out.println("""res3: String = """ + $show(res$3));$skip(48); val res$4 = 
	show(Sum(Prod(Number(2), Var("x")), Var("y")));System.out.println("""res4: String = """ + $show(res$4));$skip(48); val res$5 = 
	show(Prod(Sum(Number(2), Var("x")), Var("y")));System.out.println("""res5: String = """ + $show(res$5))}

	
}
