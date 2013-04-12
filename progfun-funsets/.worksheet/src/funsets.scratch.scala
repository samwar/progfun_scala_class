package funsets

object scratch {
  import FunSets._;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(288); 

  def listSet(elems: List[Int]): Set = (x: Int) => {
    def listMember(x: Int, L: List[Int]): Boolean = {
      if (L.isEmpty) false
      else if (x == L.head) true
      else listMember(x, L.tail)
    }
    listMember(x, elems)
  };System.out.println("""listSet: (elems: List[Int])Int => Boolean""");$skip(35); 

  
  

  val s1 = singletonSet(1);System.out.println("""s1  : Int => Boolean = """ + $show(s1 ));$skip(27); 
  val s2 = singletonSet(2);System.out.println("""s2  : Int => Boolean = """ + $show(s2 ));$skip(27); 
  val s3 = singletonSet(3);System.out.println("""s3  : Int => Boolean = """ + $show(s3 ));$skip(25); 
  val s4 = union(s1, s2);System.out.println("""s4  : Int => Boolean = """ + $show(s4 ));$skip(25); 
  val s5 = union(s3, s4);System.out.println("""s5  : Int => Boolean = """ + $show(s5 ));$skip(210); 

  def forall(s: Set, p: Int => Boolean): Boolean = {
    def iter(a: Int): Boolean = {
      if (a > bound) true
      else if (contains(s, a)) contains(p, a)
      else iter(a + 1)
    }
    iter(-bound)
  };System.out.println("""forall: (s: Int => Boolean, p: Int => Boolean)Boolean""");$skip(25); val res$0 = 

	forall(s5, (x=> x <2));System.out.println("""res0: Boolean = """ + $show(res$0))}
	
}
