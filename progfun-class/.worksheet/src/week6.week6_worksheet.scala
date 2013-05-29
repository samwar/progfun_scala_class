package week6

object week6_worksheet {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(70); 

  val xs = Array(1, 2, 3, 44);System.out.println("""xs  : Array[Int] = """ + $show(xs ));$skip(22); val res$0 = 
  xs map (x => x * 2);System.out.println("""res0: Array[Int] = """ + $show(res$0));$skip(25); 

  val s = "Hello World";System.out.println("""s  : String = """ + $show(s ));$skip(28); val res$1 = 
  s filter (c => c.isUpper);System.out.println("""res1: String = """ + $show(res$1));$skip(29); val res$2 = 

  s exists (c => c.isUpper);System.out.println("""res2: Boolean = """ + $show(res$2));$skip(28); val res$3 = 
  s forall (c => c.isUpper);System.out.println("""res3: Boolean = """ + $show(res$3));$skip(35); 

  val pairs = List(1, 2, 3) zip s;System.out.println("""pairs  : List[(Int, Char)] = """ + $show(pairs ));$skip(14); val res$4 = 
  pairs.unzip;System.out.println("""res4: (List[Int], List[Char]) = """ + $show(res$4));$skip(33); val res$5 = 

  s flatMap (c => List('.', c));System.out.println("""res5: String = """ + $show(res$5));$skip(10); val res$6 = 

  xs.sum;System.out.println("""res6: Int = """ + $show(res$6));$skip(9); val res$7 = 
  xs.max;System.out.println("""res7: Int = """ + $show(res$7));$skip(71); 

	def isPrime(n: Int) : Boolean = (2 until n) forall (x => n % x != 0);System.out.println("""isPrime: (n: Int)Boolean""");$skip(14); val res$8 = 
	
	isPrime(7);System.out.println("""res8: Boolean = """ + $show(res$8))}
}
