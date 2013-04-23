package week3


object week3_worksheet {
	val t1 = new NonEmpty(3, Empty, Empty)    //> t1  : week3.NonEmpty = {.3.}
	val t2 = t1 incl 4                        //> t2  : week3.IntSet = {.3{.4.}}
	Empty contains 1                          //> res0: Boolean = false
	(new NonEmpty(7, Empty, Empty)) contains 7//> res1: Boolean = true
	
	new Rational(1,2)                         //> res2: week3.Rational = 1/2
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