package lectures

object AnonymousFunctions extends App{


  val doubler = new Function1[Int, Int] {
    override def apply(x: Int): Int = x * 2
  }

  val doublerLikeAbowe: Int => Int = (x: Int) => x*2

  val adder: (Int, Int) => Int = (a: Int, b: Int) => a + b

  val noInput: () => Int = () => 3

  println(noInput())

  val stringToInt = (str: String) => str.toInt

  val stringFormater: (String,String) => String = "1" + _ + "2" + _

  println(stringFormater("a","b"))
}
