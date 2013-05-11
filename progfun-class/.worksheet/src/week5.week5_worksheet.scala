package week5
import math.Ordering

object week5_worksheet {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(134); 

  def removeAt[T](n: Int, xs: List[T]) = (xs take n) ::: (xs drop n + 1);System.out.println("""removeAt: [T](n: Int, xs: List[T])List[T]""");$skip(262); 

  def flatten(xs: List[Any]): List[Any] =
    xs match {
      case Nil => Nil
      case Nil :: xs => flatten(xs)
      case (z :: zs) :: Nil => flatten(z :: zs)
      case (z :: zs) :: xs => z :: flatten(zs :: xs)
      case x :: xs => x :: flatten(xs)
    };System.out.println("""flatten: (xs: List[Any])List[Any]""");$skip(53); val res$0 = 

  flatten(List(List(1, 1), 2, List(3, List(5, 8))));System.out.println("""res0: List[Any] = """ + $show(res$0));$skip(232); 

  //TA Solved
  def flatten2(xs: List[Any]): List[Any] =
    xs match {
      case Nil => Nil
      case Nil :: xs => flatten2(xs)
      case (z :: zs) :: xs => z :: flatten2(zs :: xs)
      case x :: xs => x :: flatten2(xs)
    };System.out.println("""flatten2: (xs: List[Any])List[Any]""");$skip(54); val res$1 = 

  flatten2(List(List(1, 1), 2, List(3, List(5, 8))));System.out.println("""res1: List[Any] = """ + $show(res$1));$skip(489); 

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
  };System.out.println("""msort: [T](xs: List[T])(implicit ord: scala.math.Ordering[T])List[T]""");$skip(35); 

  val nums = List(2, -4, 5, 7, 1);System.out.println("""nums  : List[Int] = """ + $show(nums ));$skip(14); val res$2 = 
  msort(nums);System.out.println("""res2: List[Int] = """ + $show(res$2));$skip(125); 

  def squareList(xs: List[Int]): List[Int] = xs match {
    case Nil => Nil
    case y :: ys => y * y :: squareList(ys)
  };System.out.println("""squareList: (xs: List[Int])List[Int]""");$skip(73); 

  def squareListMap(xs: List[Int]): List[Int] =
    xs map (x => x * x);System.out.println("""squareListMap: (xs: List[Int])List[Int]""")}
}
