package week3


object week3_worksheet {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(80); 
	val t1 = new NonEmpty(3, Empty, Empty);System.out.println("""t1  : week3.NonEmpty = """ + $show(t1 ));$skip(20); 
	val t2 = t1 incl 4;System.out.println("""t2  : week3.IntSet = """ + $show(t2 ));$skip(18); val res$0 = 
	Empty contains 1;System.out.println("""res0: Boolean = """ + $show(res$0));$skip(44); val res$1 = 
	(new NonEmpty(7, Empty, Empty)) contains 7;System.out.println("""res1: Boolean = """ + $show(res$1));$skip(21); val res$2 = 
	
	new Rational(1,2);System.out.println("""res2: week3.Rational = """ + $show(res$2))}
}

abstract class IntSet {
  def incl(x: Int): IntSet
  def contains(x: Int): Boolean
  def union(other:IntSet):IntSet
}

object Empty extends IntSet { // object makes this a singleton
  def contains(x: Int): Boolean = false;
  def incl(x: Int): IntSet = new NonEmpty(x, Empty, Empty)
  override def toString = "."
  def union(other:IntSet):IntSet = other
}

class NonEmpty(elem: Int, left: IntSet, right: IntSet) extends IntSet {
  def contains(x: Int): Boolean =
    if (x < elem) left contains x
    else if (x > elem) right contains x
    else true
  
  def incl(x: Int): IntSet =
    if (x < elem) new NonEmpty(elem, left incl x, right)
    else if (x > elem) new NonEmpty(elem, left, right incl x)
    else this
	
	override def toString ="{" +left + elem+ right +"}"
	
	def union(other:IntSet):IntSet =
		((left union right) union other) incl elem
}
