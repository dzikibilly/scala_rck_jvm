package exercises

import javafx.scene.control.SplitPane.Divider

object exception extends App{

  val aWeardValue = new NullPointerException


  val tryCatch = try{
    throw aWeardValue
  }catch {
    case error: NullPointerException => println("Null pointer error")
  }finally {
    println("Tear down")
  }

  println(tryCatch)

  case class IntBOundries(max: Int, min: Int)

  abstract class Calculator{
    def add(a: Int, b:Int): Int
    def subtract(a: Int, b:Int): Int
    def multiply(a: Int, b:Int): Int
    def divide(a: Int, b:Int): Double
  }

  class PocketCalculator(max: Int, min: Int) extends Calculator{
    println("Init")
    val boundries = IntBOundries(max=max, min=min)
    def add(a: Int, b:Int): Int = {
      val sum = a + b
      if(sum > boundries.max) throw new OutOfMemoryError()
      sum
    }
    def subtract(a: Int, b:Int): Int = {
      val sub = a - b
      if(sub < boundries.min) throw new StackOverflowError()
      sub
    }
    def multiply(a: Int, b:Int): Int = {
      val mpl = a * b
      mpl
    }
    def divide(a: Int, b:Int): Double = {
      if(b == 0) throw new ArithmeticException("Dividing be zero U moron")
      a / b
    }
  }

  val pocket = new PocketCalculator(100,-100)
  pocket.divide(1,0)
}
