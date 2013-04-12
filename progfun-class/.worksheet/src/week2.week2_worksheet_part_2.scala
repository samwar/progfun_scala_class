package week2

object week2_worksheet_part_2 {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(75); 
  val x = new Rational(1, 3);System.out.println("""x  : week2.Rational = """ + $show(x ));$skip(29); 
  val y = new Rational(5, 7);System.out.println("""y  : week2.Rational = """ + $show(y ));$skip(29); 
  val z = new Rational(3, 2);System.out.println("""z  : week2.Rational = """ + $show(z ));$skip(10); val res$0 = 
  x.numer;System.out.println("""res0: Int = """ + $show(res$0));$skip(10); val res$1 = 
  x.denom;System.out.println("""res1: Int = """ + $show(res$1));$skip(12); val res$2 = 
  x - y - z;System.out.println("""res2: week2.Rational = """ + $show(res$2));$skip(8); val res$3 = 
  y + y;System.out.println("""res3: week2.Rational = """ + $show(res$3));$skip(8); val res$4 = 
  x < y;System.out.println("""res4: Boolean = """ + $show(res$4));$skip(10); val res$5 = 
  x max y;System.out.println("""res5: week2.Rational = """ + $show(res$5));$skip(80); val res$6 = 
  //val strange = new Rational(1, 0)
  //strange.add(strange)
  new Rational(5);System.out.println("""res6: week2.Rational = """ + $show(res$6));$skip(8); val res$7 = 
  x * y;System.out.println("""res7: week2.Rational = """ + $show(res$7));$skip(8); val res$8 = 
  x / y;System.out.println("""res8: week2.Rational = """ + $show(res$8))}

}

class Rational(x: Int, y: Int) {
  require(y != 0, "denominator must be nonzero")

  def this(x: Int) = this(x, 1)

  private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
  val numer = x / gcd(x, y)
  val denom = y / gcd(x, y)

  def <(that: Rational) = this.numer * that.denom < that.numer * this.denom

  def max(that: Rational) = if (this < (that)) that else this

  def +(that: Rational) =
    new Rational(
      this.numer * that.denom + that.numer * this.denom,
      this.denom * that.denom)

  def -(that: Rational) =
    this + -that

  def *(that: Rational) = new Rational(this.numer * that.numer, this.denom * that.denom)
  
  def /(that: Rational) = new Rational(this.numer * that.denom, this.denom * that.numer)

  def unary_- : Rational = new Rational(-numer, denom)

  override def toString = numer + "/" + denom
}
