package playground

import scala.annotation.tailrec

object ScalaClass extends App {
  println("Hello scala!")

  val code = {
    val y = 2

  }
  println(code)

  def mnozenie_stringa(str: String, n: Int): String = {
    if(n==1) str
    else
      str + mnozenie_stringa(str, n-1)
  }
  println(mnozenie_stringa("abc ", 9))

  def greeting(name: String, age: Int): String = {
    "Hello " + name + " your age is " + age
  }
  println(greeting("Wacek", 34))

  def factorial(n: Int): Int = {
    if(n==1) n
    else
      n * factorial(n-1)
  }
  println(factorial(4))


  def factorail_2(n: BigInt, acumulator:BigInt): BigInt = {
    if (n <=1) acumulator
    else
      factorail_2(n-1, n * acumulator)
  }

  println(factorail_2(3000,1))

  def print_multiple(n: Int, str: String, acc: String): String = {
    if(n <= 1) acc
    else
      print_multiple(n-1,str,acc + str)
  }

  def print_multiple2(n: Int, str: String): String = {
    if(n <= 1) str
    else
      str + print_multiple2(n-1,str)
  }

//  println(print_multiple(50000,"abc","abc"))
//  println(print_multiple2(5000,"abc"))

  @tailrec
  def is_prime(n: Int,dzielnik: Int): Boolean = {
//    println(f"Is prime executed $dzielnik time")
    if ( dzielnik <= 1) true
    else if (n%dzielnik == 0 && dzielnik !=0)
      false
    else
      is_prime(n, dzielnik - 1)
  }

  is_prime(3583,3582)


//  def fibonaci_2(n: Int): Int = {
//    @tailrec
//    def fibbo(n: Int, acc: Int): Int = {
//        if(n == 0) 0
//        else if (n == 1) 1
//        else
//          fibbo(n-1, acc + fibbo(n-2,acc))
//    }
//    fibbo(n)
//  }
//  println(fibonaci_2(40000))
}
