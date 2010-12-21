package ph.gutierrez.learning.scala {

  // Private primary ctor params translate to private property
  class Wine(
    val varietal: String,
    val name: String,
    private val year: Int,
    val vineyard: String,
    protected var price: BigDecimal) {

    require(name != null, "'name' is required.")

    def this(name: String) = this("", name, 1900, "", 1.0)

    def this() = {
      this("test")

      println("test")
    }

    def computeTaninLevel(): Int = {
      0
    }
  }

  class WhiteWine extends Wine("BasedaCd") {
    println("In White: " + price)
  }

  object Equality {

    def main(args: Array[String]): Unit = {
      val constant = "This is a test"
      val constructed = new String("This is a test")

      println("constant hash: " + constant.hashCode)
      println("constructed hash: " + constructed.hashCode)

      // Vars declared in the primary ctor automatically get a mutator; vals don't
      val bottleOne = new Wine("Merlot", "...", 2006, "Ledson", BigDecimal.valueOf(30.50))

      // price is not visible since it's protected. It would have been in Java.
      // println(bottleOne.price)
      
      val white = new WhiteWine()
    }
  }
}


package ph.gutierrez.learning.scalatoo {
	import ph.gutierrez.learning.scala._;
	
	class RedWine extends Wine {
		println(price)
	}
}
