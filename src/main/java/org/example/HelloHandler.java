package org.example;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;

public class HelloHandler implements HttpHandler {

    @Override
    public void handle(HttpExchange exchange) throws IOException {

        String response = "Hello from Http server";

        exchange.sendResponseHeaders(200, response.length());

        exchange.getResponseBody().write(response.getBytes());

        exchange.getResponseBody().close();

    }
}
