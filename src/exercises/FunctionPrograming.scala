package exercises

object FunctionPrograming extends App{

  val concat: ((String,String) => String) = new Function2[String, String, String]  {
    override def apply(v1: String,v2: String): String = v1 + v2
  }

  println(concat.apply("a", "b"))

//  trait MyPredicat[-T]{
//    def test(test: T): Boolean
//  }
//
//  trait MyTransformer[-A, B] {
//    def transform(obj: A): B
//  }

//  val myPred:(A) => Boolean = new Function[A] {}

//  val FunFun2: (Int,Function1[Int,Int]) => Function1[Int,Int]= new Function1[Int,Function1[Int,Int]] {
//    override def apply(v1: Int, fun: Function1[Int,Int]): ((Int,Function1[Int,Int]) => Int) = {
//      new Function1[Int,Int] {
//        override def apply(v1: Int): Int = v1
//      }
//    }
//  }

    val superAdder: Function1[Int, Function1[Int,Int]] = new Function[Int, Function1[Int,Int]] {
      override def apply(x: Int): Function1[Int,Int] = new Function[Int,Int] {
        override def apply(y: Int): Int = x + y
      }
    }

    val adder1 = superAdder(5)
    val adder2 = superAdder
    println(adder1)
    println(adder1(3))
    println(adder1(3))
    println(adder2(3)(10))

}
