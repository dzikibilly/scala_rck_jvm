package exercises

object caseCLass extends App {

  case class Person(name: String, year: Int)

  val prsn1 = Person("Marcin", 1234)
  println(prsn1)
  printData(prsn1)
  val prsn2 = Person("Damian", 456)
  println(prsn2)
  printData(prsn2)

  val prsn3 = prsn2.copy(year = 778)

  println(prsn1 == prsn2)
  println(prsn3)
  println(prsn3.hashCode())
  println(prsn2.hashCode())
  println(prsn1.hashCode())


  def printData(prson: Person): Unit ={
    println(f"${prson.name} is ${prson.year} old")
  }

  case object SImpleObject{
    def name: String = "some object"
  }

  println(SImpleObject.name)

}
