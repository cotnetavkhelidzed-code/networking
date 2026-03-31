package org.example;

import com.fasterxml.jackson.core.PrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

public class PupilHandler implements HttpHandler {
    private final PupilRepository pupilRepository;
    private final ObjectMapper objectMapper;

    public PupilHandler() {
        this.pupilRepository =new PupilRepository();
        this.objectMapper = new ObjectMapper();
    }

    @Override
    public void handle(HttpExchange exchange) throws IOException {

        if (!exchange.getRequestMethod().equalsIgnoreCase("GET")) {
            exchange.sendResponseHeaders(405, -1);
            return;
        }
        List<Pupil> pupils = pupilRepository.getAllpupils();

        String jsonResponse = objectMapper.writeValueAsString(pupils);

        exchange.getResponseHeaders().add("Content-type", "Application/json");

        byte[] responseBytes = jsonResponse.getBytes();
        exchange.sendResponseHeaders(200, responseBytes.length);

        OutputStream os = exchange.getResponseBody();
        os.write(responseBytes);
        os.close();

    }


}
