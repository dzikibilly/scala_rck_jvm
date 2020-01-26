package exercises

import scala.runtime.Nothing$


abstract class MyList[+A] {

  def head: A
  def tail: MyList[A]
  def isEmpty: Boolean
  def add[B >: A](element: B): MyList[B]
  def printElements: String
  // polymorphic call
  override def toString: String = "[" + printElements + "]"

  def map[B](transform: A =>B): MyList[B]
  def flatmap[B](mLis: A => MyList[B]): MyList[B]
  def filter(pred: A => Boolean): MyList[A]
  def ++[B >:A](list: MyList[B]): MyList[B]

}

case object Empty extends MyList[Nothing] {
  def head: Nothing = throw new NoSuchElementException
  def tail: MyList[Nothing] = throw new NoSuchElementException
  def isEmpty: Boolean = true
  def add[B >: Nothing](element: B): MyList[B] = new Cons(element, Empty)
  def printElements: String = ""

  def map[B](transform: Nothing => B): MyList[B] = Empty
  def filter(pred: Nothing => Boolean): MyList[Nothing] = Empty

  def ++[B >: Nothing](list: MyList[B]): MyList[B] = list
  def flatmap[B](mLis: Nothing => MyList[B]): MyList[B] = Empty
}

case class Cons[+A](h: A, t: MyList[A]) extends MyList[A] {
  def head: A = h
  def tail: MyList[A] = t
  def isEmpty: Boolean = false
  def add[B >: A](element: B): MyList[B] = new Cons(element, this)
  def printElements: String =
    if(t.isEmpty) "" + h
    else h + " " + t.printElements

  def filter(predicate: A => Boolean): MyList[A] = {
    if (predicate(h)) new Cons[A](h, t.filter(predicate))
    else t.filter(predicate)
  }
  def map[B](transform: A => B): MyList[B] = {
    new Cons[B](transform(h), t.map(transform))
  }

  def ++[B >: A](list: MyList[B]): MyList[B] = new Cons[B](h, tail ++ list)

  def flatmap[B](mLis: A => MyList[B]): MyList[B] = {
    mLis(h) ++ t.flatmap(mLis)
  }
}

trait MyPredicat[-T]{   //zastapione  T => Boolean
  def test(test: T): Boolean
}

trait MyTransformer[-A, B] {    //zastapione A => B
  def transform(obj: A): B
}


object MyList extends App {
  val listOfIntegers: MyList[Int] = new Cons(1, new Cons(2, new Cons(3, Empty)))
  val cloneListOfIntegers: MyList[Int] = new Cons(1, new Cons(2, new Cons(3, Empty)))
  val anotherListOfIntegers: MyList[Int] = new Cons(4, new Cons(5, Empty))
  val anotherListOfIntegers_2: MyList[Int] = new Cons(4, new Cons(5, new Cons[Int](56, Empty)))
  val listOfStrings: MyList[String] = new Cons("Hello", new Cons("Scala", Empty))

  println(listOfIntegers.toString)
  println(listOfStrings.toString)
  println(anotherListOfIntegers.toString)

  val mapowane = anotherListOfIntegers.map(new MyTransformer[Int,Int] {
    override def transform(obj: Int): Int = obj * 2
  })

  val predecate = new MyPredicat[Int] {
    override def test(test: Int): Boolean = test % 2 ==0
  }

  println(anotherListOfIntegers.filter(new MyPredicat[Int] {
    override def test(test: Int): Boolean = test % 2 ==0
  }).toString)

  println(mapowane.filter(predecate).toString)

  val sum = anotherListOfIntegers ++ mapowane

  println(sum.toString)

  val forFlatMap = anotherListOfIntegers_2.flatmap(new MyTransformer[Int, MyList[Int]] {
    override def transform(obj: Int): MyList[Int] = new Cons[Int](obj, new Cons[Int](obj + 1, Empty))
  })
}