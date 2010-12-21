package ph.gutierrez.learning.scala

import scala.collection.mutable._

trait EventDispatcher {
  type Observer = { def onEvent(subject: Any) }

  val observers = new ListBuffer[Observer]()

  def dispatchEvent(): Unit = observers.foreach(_.onEvent(this))
}


class Widget {
  def click(x: Int, y: Int): Unit = {
    println("button clicked.")
  }
}

/**
 * A button with event dispatching as a mixin.
 */
class ObservableWidget extends Widget with EventDispatcher{
  override def click(x: Int, y: Int): Unit = {
    super.click(x, y);
    dispatchEvent();
  }
}

object ButtonDriver {
  def main(args: Array[String]): Unit = {
    val button: ObservableWidget = new ObservableWidget();
    
    // Adds this object a observer (onEvent is defined here.)
    button.observers + this
    
    button.click(9, 10)
  }
  
  def onEvent(observed: Any) {
  	println("Observer invoked!")
  }
}