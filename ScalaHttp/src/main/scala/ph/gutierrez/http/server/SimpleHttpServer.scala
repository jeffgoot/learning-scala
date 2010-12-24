package ph.gutierrez.http.server
import concurrent.ops;

import java.io._
import java.net.{ Socket, ServerSocket, SocketTimeoutException }

/**
 * Main HTTP Server class.
 * 
 * @author <a href="mailto:jeff@gutierrez.ph">Jeff Gutierrez</a>
 * @version $Revision$ $Date$
 * @since 0.1
 */
class SimpleHttpServer(val portNumber: Int, val documentRoot: String) {
  require(portNumber > 0, "'portNumber' must be > 0")
  require(documentRoot != null && documentRoot.length > 0 && new File(documentRoot).isDirectory, "'documentRoot' must be a valid directory.")

  def this(documentRoot: String) = this(56789, documentRoot)

  var die: Boolean = false;

  /**
   * Starts the server. This blocks waiting for new connections and until it is signaled to die.
   */
  def start(): Unit = {
    val server = new ServerSocket(portNumber)
    server.setSoTimeout(500)
    
    while (!die) {
      try {
        val socket = server.accept
        
        // XXX can service only one client at a time.
       	new SimpleHttpWorker(socket).serviceRequest()
       	
      } catch {
        case e: SocketTimeoutException => //NO-OP
        case unknown => {
          println("Unknown exception: " + unknown + "; bailing out")
          die = true
        }
      }
    }
  }
}

/**
 * Startup class.
 * 
 * @author <a href="mailto:jeff@gutierrez.ph">Jeff Gutierrez</a>
 * @version $Revision$ $Date$
 * @since 0.1
 */
object SimpleHttpServer {
  def main(args: Array[String]): Unit = {
    val server = new SimpleHttpServer(1055, "/home/jeff/tmp")
    server.start()
  }
}

