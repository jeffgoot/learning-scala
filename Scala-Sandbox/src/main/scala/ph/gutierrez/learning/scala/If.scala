package ph.gutierrez.learning.scala

object If {

  def main(args: Array[String]): Unit = {
  	for(child <- filterAndYield()) println(child)
  	
  	filters()  	
    
  	counterLoop(1)  
  	
  	listLoop()
  }

  def filterAndYield(): List[String] = {
  	val children = List("Janica", "Eisha", "Jason", "Lorenz", "Nate", "Dani")
  	val filtered = for {
  		child <- children
  		if child.size > 5 
  	} yield child
  	
  	return filtered
  }
  
  def filters() {
  	var wineries = List("Ledson", "La Crema", "Foley", "Kendal Jackson")
  	for(winery <- wineries if winery.split(" ").length > 1 || winery.startsWith("L") ) println(winery)
  }
  
  def listLoop() {
    val variatals = List("Pinot Noir", "Cabernet Sauvignon", "Cavernet Franc", "Merlot", "Shiraz")
    for (grape <- variatals) {
    	println(grape)
    }
  }

  def counterLoop(to: Int) {
    // Counter loop
    for (counter <- 0 until to) {
      val value: Long = System.currentTimeMillis

      // Every statement evaluates to a function.
      val ok = if (value % 2 == 0) {
        value % 4 == 0
      } else {
        value % 3 == 0
      }

      println(counter + ":" + ok + ":" + value)
      Thread.sleep((Math.random * 1000).asInstanceOf[Long])
    }

  }

}