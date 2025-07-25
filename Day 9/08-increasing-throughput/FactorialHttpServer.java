import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpExchange;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

public class FactorialHttpServer {

    public static void main(String[] args) throws IOException {
    	
        // Create an HTTP server listening on port 8080
        HttpServer server = HttpServer.create(new InetSocketAddress(8086), 0);
        
//        int numThreads = Runtime.getRuntime().availableProcessors();
//        server.setExecutor(Executors.newFixedThreadPool(numThreads));
        
        int numThreads = Runtime.getRuntime().availableProcessors() /2 ;
        server.setExecutor(Executors.newFixedThreadPool(numThreads));
//        
        
        
        // Create a context that listens for requests on /factorial
        server.createContext("/factorial", (HttpExchange exchange) -> {
            try {
                Thread.sleep(5); // Simulating a process that takes time
                exchange.sendResponseHeaders(200, "HELLO WORLD".getBytes().length);
                OutputStream os = exchange.getResponseBody();
                os.write("HELLO WORLD".getBytes());
                os.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        // Start the server
        server.start();
        System.out.println("Server started on port 8086");
    }
}



