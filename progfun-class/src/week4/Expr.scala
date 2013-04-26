package week4

trait Expr 
case class Number(n:Int) extends Expr
case class Sum(e1: Expr, e2: Expr) extends Expr
case class Prod(x:Expr, y: Expr) extends Expr
case class Var(v:String) extends Expr
