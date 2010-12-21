package ph.gutierrez.sandbox.scala

object Closures {

  def periodicTimer(seconds: Int, callback: () => Unit): Unit = {
  		while(true) {
  			callback()
  			Thread.sleep(seconds * 1000)
  		}
  }

  def main(args: Array[String]): Unit = {
  	periodicTimer(2, () => Console.println("Test"))
  }
}