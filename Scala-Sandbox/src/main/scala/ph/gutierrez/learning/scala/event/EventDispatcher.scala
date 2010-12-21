package ph.gutierrez.learning.scala.e2

import scala.collection.mutable._

trait Clickable {
  def click(x: Int, y: Int)
}

class Widget extends Clickable {
  def click(x: Int, y: Int): Unit = {
    println("button clicked.")
  }
}

trait EventDispatcher {
  type Observer = { def onEvent(subject: Any) }

  val observers = new ListBuffer[Observer]()

  def dispatchEvent(): Unit = observers.foreach(_.onEvent(this))
}

trait ObservableClicks extends Clickable with EventDispatcher {
  abstract override def click(x: Int, y: Int) = {
    super.click(x, y)
    dispatchEvent()
  }
}


object ButtonDriver {
  def main(args: Array[String]): Unit = {
  	val button = new Widget() with ObservableClicks
  	button.observers + this 
  	button.click(9, 2)
  }

  def onEvent(observed: Any) {
    println("Observer invoked!")
  }
}