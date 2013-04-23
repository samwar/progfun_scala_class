package week3

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