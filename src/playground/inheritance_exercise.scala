//package playground
//
//import scala.collection.View.Empty
//import scala.runtime.Nothing$
//
//object inheritance_exercise extends App {
//
//  abstract class MyLIst[+A] {
//    def head: A
//
//    def tail: MyLIst[A]
//
//    def isEmpty: Boolean
//
//    def add[B >: A](n: B): MyLIst[B]
//
//    def printToConsole: String
//
//    override def toString: String = "[" + printToConsole + "]"
//
//    def map[B](transformer: MyTransformer[A,B]): MyLIst[B]
//    def flatMap[B](transformer: MyTransformer[A, MyLIst[B]]): MyLIst[B]
//    def filter(predicate: MyPredicate[A]): MyLIst[A]
//
//  }
//
//  class Empty extends MyLIst[Nothing] {
//    def head: Nothing = throw new NoSuchElementException
//
//    def tail: MyLIst[Nothing] = throw new NoSuchElementException
//
//    def isEmpty: Boolean = true
//
//    def add[B >: Nothing](n: B): Const[B] = new Const(n, this)
//
//    def printToConsole: String = ""
//
//    def map[B](transform: MyTransformer[Nothing,B]): MyLIst[B] = Empty
//    def flatMap[B](transformer: MyTransformer[Nothing, MyLIst[B]]): MyLIst[B] = Empty
//    def filter(predicate: MyPredicate[Nothing]): MyLIst[Nothing] = Empty
//
//  }
//
//  class Const[+A](pierwszy: A, rest: MyLIst[A]) extends MyLIst[A]{
//      def head: A = pierwszy
//
//      def tail: MyLIst[A] = rest
//
//      def isEmpty: Boolean = false
//
//      def add[B >:A](n: B): Const[B] = new Const(n, this)
//
//       def printToConsole: String = {
//        if(rest.isEmpty) "" + head
//        else
//          head + " " + rest.printToConsole
//      }
//
//    def map[B](transformer: MyTransformer[A,B]): MyLIst[B] = {
//       new Const(transformer.transform(pierwszy), rest.map(transformer))
//    }
//    def flatMap[B](transformer: MyTransformer[A, MyLIst[B]]): MyLIst[B] = Empty
//    def filter(predicate: MyPredicate[A]): MyLIst[A] = {
//      if(predicate.test(pierwszy)) new Const[A](pierwszy, rest.filter(predicate))
//      else rest.filter(predicate)
//    }
//  }
//
//  trait MyPredicate[-T]{
//    def test(elem: T): Boolean
//  }
//
//  trait MyTransformer[-A,B]{
//    def transform(elem: A): B
//  }
//
//
//  val lista_1 = new Empty
//  val list_2 = new Const[String]("lista_1", new Const[String]("abcd",
//    lista_1))
//  println(list_2.toString)
//
//
//
////
////  val lista_2 = new Const(1, lista_1)
////
////  val lista_3 = new Const(123, lista_2)
////
////  println(lista_2.toString)
////  println(lista_3.toString)
//}
