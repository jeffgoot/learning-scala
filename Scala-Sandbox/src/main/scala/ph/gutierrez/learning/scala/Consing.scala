/**
 * $Header$
 * 
 * Scala-Sandbox - ph.gutierrez.learning.scala
 * 
 * Copyright (C) 2010 gutierrez.ph
 * All Rights Reserved
 * 
 **/
package ph.gutierrez.learning.scala

/**
 * @author <a href="mailto:jeff@gutierrez.ph">Jeff Gutierrez</a>
 * @version $Revision$ $Date$
 * @since 0.1
 */
object Consing {

  def main(args: Array[String]) {
    val oneTwo = List(1, 2)
    val threeFour = List(3, 4)
    val all = oneTwo ::: threeFour
    
    println(all)
  }

}