package by.cost_control.by.cost_control;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

import com.sun.net.httpserver.HttpServer;

public class App {
	public static void main(String[] args) {
		int serverPort = 9090;
		HttpServer server;
		try {
			server = HttpServer.create(new InetSocketAddress(serverPort), 0);
			server.createContext("/api/hello", (exchange -> {
				String respText = "Hello!";
				exchange.sendResponseHeaders(200, respText.getBytes().length);
				OutputStream output = exchange.getResponseBody();
				output.write(respText.getBytes());
				output.flush();
				exchange.close();
			}));
			server.setExecutor(null); // creates a default executor
			server.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
