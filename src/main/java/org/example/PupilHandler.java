package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PupilHandler extends PupilRepository implements HttpHandler {
    private final PupilRepository pupilRepository;
    private final ObjectMapper objectMapper;

    public PupilHandler() {
        this.pupilRepository =new PupilRepository();
        this.objectMapper = new ObjectMapper();
    }

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        List<Pupil> pupils = pupilRepository.getAllpupils();


        String query = exchange.getRequestURI().getRawQuery();
        if (!exchange.getRequestMethod().equalsIgnoreCase("GET")) {
            exchange.sendResponseHeaders(405, -1);
            return;
        }else {
            String name = query.substring(5);
            System.out.println(name);
            pupils = pupils.stream()
                    .filter(pupil-> pupil.getName().equalsIgnoreCase(name))
                    .collect(Collectors.toList());

        }

//        if (query != null && query.contains("name=")){
//
//
//        }


        String jsonResponse = objectMapper.writeValueAsString(pupils);

        exchange.getResponseHeaders().add("Content-type", "Application/json");

        byte[] responseBytes = jsonResponse.getBytes();
        exchange.sendResponseHeaders(200, responseBytes.length);

        OutputStream os = exchange.getResponseBody();
        os.write(responseBytes);
        os.close();

    }

    public void handlePost(HttpExchange exchange)throws IOException{

        Pupil newPupil = objectMapper.readValue(exchange.getRequestBody(), Pupil.class);


    }


}
