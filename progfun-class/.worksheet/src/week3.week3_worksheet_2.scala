package week3

object week3_worksheet_2 {

  // Traits resemeble interfaces in Java, but much more powerful - can contain fields and method implmentations which interfaces cannot
  // Traits never have parameters - cannot have val
  trait Planar {
    def height: Int
    def width: Int
    def surface = height * width
  };import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(389); 

  //Type Nothing
  def error(msg: String) = throw new Error(msg);System.out.println("""error: (msg: String)Nothing""");$skip(34); 
  //error("test")

  val x = null;System.out.println("""x  : Null = """ + $show(x ));$skip(20); 
  val y: String = x;System.out.println("""y  : String = """ + $show(y ));$skip(26); val res$0 = 

  if (true) 1 else false;System.out.println("""res0: AnyVal = """ + $show(res$0));$skip(61); 

  def singleton[T](elem: T) = new Cons[T](elem, new Nil[T]);System.out.println("""singleton: [T](elem: T)week3.Cons[T]""");$skip(20); val res$1 = 
  singleton[Int](1);System.out.println("""res1: week3.Cons[Int] = """ + $show(res$1));$skip(27); val res$2 = 
  singleton[Boolean](true);System.out.println("""res2: week3.Cons[Boolean] = """ + $show(res$2));$skip(70); val res$3 = 

  //Compiler can infer types, so they can be left out
  singleton(1);System.out.println("""res3: week3.Cons[Int] = """ + $show(res$3));$skip(18); val res$4 = 
  singleton(true);System.out.println("""res4: week3.Cons[Boolean] = """ + $show(res$4));$skip(312); 

  //Type parameters do not affect evaulation in Scala
  //We can assume that all type parameters and type arguments are removed before evaluating the program

  def nth[T](n: Int, xs: List[T]): T =
    if(xs.isEmpty) throw new IndexOutOfBoundsException
    else if (n == 0) xs.head
    else nth(n - 1, xs.tail);System.out.println("""nth: [T](n: Int, xs: week3.List[T])T""");$skip(61); 

  val list = new Cons(1, new Cons(2, new Cons(3, new Nil)));System.out.println("""list  : week3.Cons[Int] = """ + $show(list ));$skip(15); val res$5 = 
  nth(2, list);System.out.println("""res5: Int = """ + $show(res$5));$skip(15); val res$6 = 
  nth(4, list);System.out.println("""res6: Int = """ + $show(res$6))}
}
