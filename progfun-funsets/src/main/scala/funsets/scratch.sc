package funsets

object scratch {
  import FunSets._

  def listSet(elems: List[Int]): Set = (x: Int) => {
    def listMember(x: Int, L: List[Int]): Boolean = {
      if (L.isEmpty) false
      else if (x == L.head) true
      else listMember(x, L.tail)
    }
    listMember(x, elems)
  }

  
  

  val s1 = singletonSet(1)
  val s2 = singletonSet(2)
  val s3 = singletonSet(3)
  val s4 = union(s1, s2)
  val s5 = union(s3, s4)

  def forall(s: Set, p: Int => Boolean): Boolean = {
    def iter(a: Int): Boolean = {
      if (a > bound) true
      else if (contains(s, a)) contains(p, a)
      else iter(a + 1)
    }
    iter(-bound)
  }

	forall(s5, (x=> x <2))
	
}