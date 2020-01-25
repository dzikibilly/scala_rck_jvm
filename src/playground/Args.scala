package playground

object Args extends App {

class Writer(name: String, surname: String, val year: Int){

  def authorFullName: Unit ={println(s"${this.name} ${this.surname}")}
}

  class Novel(val name: String,val year_of_release: Int, val autor:Writer){


    def authorAge {println(s"Autor age is ${this.autor.year}")}

    def copy(new_year: Int): Novel = {
      new Novel(this.name, new_year, this.autor)
    }

    def isWrittenBy: Unit = {this.autor.authorFullName}

    def novelRelease: Unit = {println(s"Release is ${this.year_of_release}")}
  }

  val x = new Writer("adam", surname = "to ja spadam", 1234)
  val y = new Novel("harry", 123, x)

//  y.authorAge
//  y.isWrittenBy
//  y.novelRelease
//  val newNovelReleaseDate = y.copy(2019)
//  newNovelReleaseDate.novelRelease

  class Counter(n: Int){
//    println(s"Inscance of counter n=$n")
    def increment = {
//      println(s"Incrementing n=${n+1}\n")
      new Counter(n+1)
    }
    def decrement = {
//      println(s"Decrementing n=${n-1}")
      new Counter(n-1)
    }

    def increment(n: Int): Counter = {
      println(s"N=${n}")
      if(n <=0) this
      else increment.increment(n-1)
    }

    def decrement(n: Int): Counter = {
      val x = -n
      println(s"N=${x}")
      if(x >= -1) this
      else decrement.decrement(-(x+1))
    }

    def wartosc = println(s"Wartosc N = ${this.n}")
  }

  val cnt = new Counter(0)
  cnt.increment(3)
  cnt.wartosc
//  cnt.decrement(4)
//  cnt.wartosc
}

