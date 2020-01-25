package playground

object counter extends App{

  class Counter(i: Int = 0){
    def increment: Counter = new Counter(i+1)
    def decrement: Counter = new Counter(i-1)
    

    def icrement(n:Int): Counter={
      if(n<=0) this
      else increment.icrement(n-1)
    }


  }

}
