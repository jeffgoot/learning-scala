package ph.gutierrez.http.server

import java.io._
import java.net.{ Socket }
import scala.collection.mutable.ListBuffer

/**
 * Thread the handles the communication with an HTTP client.
 * 
 * @author <a href="mailto:jeff@gutierrez.ph">Jeff Gutierrez</a>
 * @version $Revision$ $Date$
 * @since 0.1
 */
class SimpleHttpWorker(
  private val clientSocket: Socket) {

	private var header = new ListBuffer[String]()
	
	private var body: String = ""
	
	/**
	 * Services a single request per connection (HTTP/1.0)
	 */
  def serviceRequest() {
    clientSocket.setTcpNoDelay(true)
    val out = new OutputStreamWriter(clientSocket.getOutputStream)
    val in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream))

    // Collect the header lines until an empty new line is hit.
    // Read the body if available.
    
    var done = false
    while (!done) {
      val line = in.readLine();
      if (line == null || "".equals(line)) {
        done = true
      } 
      
      header += line
    }

    header.foreach(println _)
    
    clientSocket.close();
  }
}