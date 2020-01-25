package playground

import scala.collection.View.Empty

object inheritance_exercise extends App {

  abstract class MyLIst[+A] {
    def head: A

    def tail: MyLIst[A]

    def isEmpty: Boolean

    def add[B >: A](n: B): MyLIst[B]

    def printToConsole: String

    override def toString: String = "[" + printToConsole + "]"
  }

  class Empty extends MyLIst[Nothing] {
    def head: Nothing = throw new NoSuchElementException

    def tail: MyLIst[Nothing] = throw new NoSuchElementException

    def isEmpty: Boolean = true

    def add[B >: Nothing](n: B): Const[B] = new Const(n, this)

    def printToConsole: String = ""
  }

  class Const[+A](pierwszy: A, rest: MyLIst[A]) extends MyLIst[A]{
      def head: A = pierwszy

      def tail: MyLIst[A] = rest

      def isEmpty: Boolean = false

      def add[B >:A](n: B): Const[B] = new Const(n, this)

       def printToConsole: String = {
        if(rest.isEmpty) "" + head
        else
          head + " " + rest.printToConsole
      }
  }


  val lista_1 = new Empty
  val list_2 = new Const[String]("lista_1", new Const[String]("abcd",
    lista_1))
  println(list_2.toString)
//
//  val lista_2 = new Const(1, lista_1)
//
//  val lista_3 = new Const(123, lista_2)
//
//  println(lista_2.toString)
//  println(lista_3.toString)
}
