package week3

object week3_worksheet_2 {

  // Traits resemeble interfaces in Java, but much more powerful - can contain fields and method implmentations which interfaces cannot
  // Traits never have parameters - cannot have val
  trait Planar {
    def height: Int
    def width: Int
    def surface = height * width
  }

  //Type Nothing
  def error(msg: String) = throw new Error(msg)   //> error: (msg: String)Nothing
  //error("test")

  val x = null                                    //> x  : Null = null
  val y: String = x                               //> y  : String = null

  if (true) 1 else false                          //> res0: AnyVal = 1

  def singleton[T](elem: T) = new Cons[T](elem, new Nil[T])
                                                  //> singleton: [T](elem: T)week3.Cons[T]
  singleton[Int](1)                               //> res1: week3.Cons[Int] = week3.Cons@4819d373
  singleton[Boolean](true)                        //> res2: week3.Cons[Boolean] = week3.Cons@17894800

  //Compiler can infer types, so they can be left out
  singleton(1)                                    //> res3: week3.Cons[Int] = week3.Cons@35d60412
  singleton(true)                                 //> res4: week3.Cons[Boolean] = week3.Cons@75a5555a

  //Type parameters do not affect evaulation in Scala
  //We can assume that all type parameters and type arguments are removed before evaluating the program

  def nth[T](n: Int, xs: List[T]): T =
    if(xs.isEmpty) throw new IndexOutOfBoundsException
    else if (n == 0) xs.head
    else nth(n - 1, xs.tail)                      //> nth: [T](n: Int, xs: week3.List[T])T

  val list = new Cons(1, new Cons(2, new Cons(3, new Nil)))
                                                  //> list  : week3.Cons[Int] = week3.Cons@3986c40d
  nth(2, list)                                    //> res5: Int = 3
  nth(4, list)                                    //> java.lang.IndexOutOfBoundsException
                                                  //| 	at week3.week3_worksheet_2$$anonfun$main$1.nth$1(week3.week3_worksheet_2
                                                  //| .scala:34)
                                                  //| 	at week3.week3_worksheet_2$$anonfun$main$1.apply$mcV$sp(week3.week3_work
                                                  //| sheet_2.scala:40)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$$anonfun$$exe
                                                  //| cute$1.apply$mcV$sp(WorksheetSupport.scala:76)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$.redirected(W
                                                  //| orksheetSupport.scala:65)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$.$execute(Wor
                                                  //| ksheetSupport.scala:75)
                                                  //| 	at week3.week3_worksheet_2$.main(week3.week3_worksheet_2.scala:11)
                                                  //| 	at week3.week3_worksheet_2.main(week3.week3_worksheet_2.scala)
}