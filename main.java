
import com.sun.net.httpserver.HttpServer;
import java.net.InetSocketAddress;

public class Main {
    public static void main(String[] args) throws Exception {

        HttpServer server = HttpServer.create(
            new InetSocketAddress(8080), 0
        );

        server.createContext("/", exchange -> {
            String response = "Welcome to My Website!";
            exchange.sendResponseHeaders(200, response.length());

            exchange.getResponseBody().write(
                response.getBytes()
            );
            exchange.close();
        });

        server.start();

        System.out.println(
            "Server running at http://localhost:8080"
        );
    }
}
