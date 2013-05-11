package week5
import math.Ordering

object week5_worksheet {

  def removeAt[T](n: Int, xs: List[T]) = (xs take n) ::: (xs drop n + 1)
                                                  //> removeAt: [T](n: Int, xs: List[T])List[T]

  def flatten(xs: List[Any]): List[Any] =
    xs match {
      case Nil => Nil
      case Nil :: xs => flatten(xs)
      case (z :: zs) :: Nil => flatten(z :: zs)
      case (z :: zs) :: xs => z :: flatten(zs :: xs)
      case x :: xs => x :: flatten(xs)
    }                                             //> flatten: (xs: List[Any])List[Any]

  flatten(List(List(1, 1), 2, List(3, List(5, 8))))
                                                  //> res0: List[Any] = List(1, 1, 2, 3, 5, 8)

  //TA Solved
  def flatten2(xs: List[Any]): List[Any] =
    xs match {
      case Nil => Nil
      case Nil :: xs => flatten2(xs)
      case (z :: zs) :: xs => z :: flatten2(zs :: xs)
      case x :: xs => x :: flatten2(xs)
    }                                             //> flatten2: (xs: List[Any])List[Any]

  flatten2(List(List(1, 1), 2, List(3, List(5, 8))))
                                                  //> res1: List[Any] = List(1, 1, 2, 3, List(5, 8))

  def msort[T](xs: List[T])(implicit ord: Ordering[T]): List[T] = {
    val n = xs.length / 2
    if (n == 0) xs
    else {
      def merge(xs: List[T], ys: List[T]): List[T] =
        (xs, ys) match {
          case (Nil, ys) => ys
          case (xs, Nil) => xs
          case (x :: xs1, y :: ys1) =>
            if (ord lt (x, y)) x :: merge(xs1, ys)
            else y :: merge(xs, ys1)
        }
      val (fst, snd) = xs splitAt n
      merge(msort(fst), msort(snd)(ord))
    }
  }                                               //> msort: [T](xs: List[T])(implicit ord: scala.math.Ordering[T])List[T]

  val nums = List(2, -4, 5, 7, 1)                 //> nums  : List[Int] = List(2, -4, 5, 7, 1)
  msort(nums)                                     //> res2: List[Int] = List(-4, 1, 2, 5, 7)

  def squareList(xs: List[Int]): List[Int] = xs match {
    case Nil => Nil
    case y :: ys => y * y :: squareList(ys)
  }                                               //> squareList: (xs: List[Int])List[Int]

  def squareListMap(xs: List[Int]): List[Int] =
    xs map (x => x * x)                           //> squareListMap: (xs: List[Int])List[Int]
}