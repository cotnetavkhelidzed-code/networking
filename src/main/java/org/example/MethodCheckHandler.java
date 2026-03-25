package org.example;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class MethodCheckHandler implements HttpHandler {

    @Override
    public void handle(HttpExchange exchange) throws IOException {

        String method = exchange.getRequestMethod();
        String response;

        if ("GET".equals(method)){
            response = "GET request proccesed";
        }else {
            exchange.sendResponseHeaders(405,-1);
            return;
        }

        exchange.sendResponseHeaders(200,response.length());
        exchange.getResponseBody().write(response.getBytes());
        exchange.getResponseBody().close();
    }
}
