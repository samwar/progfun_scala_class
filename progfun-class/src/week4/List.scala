package week4

trait List[+T] {
  def isEmpty: Boolean
  def head: T
  def tail: List[T]
  //def prepend(elem: T): List[T] = new Cons (elem, this) breaks the variance rules because it violates the Liskov Substition Principal
  def prepend[U >: T](elem: U): List[U] = new Cons (elem, this)
}

class Cons[T](val head: T, val tail: List[T]) extends List[T] {
  def isEmpty = false
}

object Nil extends List[Nothing] {// the object key word makes this a singleton
  def isEmpty = true
  def head: Nothing = throw new NoSuchElementException("Nil.head") // Type Nothing
  def tail: Nothing = throw new NoSuchElementException("Nil.tail") // Type Nothing
}

object List {
  //List (1,2) = List.apply(1,2)
  def apply[T](x1:T) :List[T] = new Cons(x1, Nil)
  def apply[T](x1: T, x2: T): List[T] = new Cons(x1, apply(x2))
  def apply[T]() = Nil
}

object test {
  val x: List[String] = Nil
  def f(xs: List[NonEmpty], x: Empty) = xs prepend x
  
}
