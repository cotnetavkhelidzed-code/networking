package org.example;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import javax.management.Query;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

import static com.sun.management.HotSpotDiagnosticMXBean.ThreadDumpFormat.JSON;

public class HelloHandler implements HttpHandler {


//    @Override
//    public void handle(HttpExchange exchange) throws IOException {
//        try {
//            String method = exchange.getRequestMethod();
//
//            if ("GET".equalsIgnoreCase(method)) {
//                handleGet(exchange);
//            } else {
//                sendText(exchange, 405, "Method Not Allowed. Use GET." );
//            }
//        } catch (IOException e) {
//           sendText(exchange, 500, "Internal Server Error: " + e.getMessage());
//        }
//        finally {
//            exchange.close();
//        }
//
//    }
//
//
//    private void handleGet(HttpExchange exchange) throws IOException {
//        String query = exchange.getRequestURI().getRawQuery();
//
//        Map<String, String> params = parseFormLikeParams(query);
//
//        // name პარამეტრის ამოღება, default მნიშვნელობა "Guest"
//        String name = params.getOrDefault("name", "Guest");
//// city პარამეტრის ამოღება, default მნიშვნელობა "Unknown"
//        String city = params.getOrDefault("city", "Unknown");
//// პასუხის ტექსტის აგება
//        String response = "GET received\n" +
//                "name = " + name + "\n" +
//                "city = " + city + "\n";
//// პასუხის გაგზავნა 200 OK სტატუსით
//        sendText(exchange, 200, response);
//    }
//
//    private static Map<String, String> parseFormLikeParams(String raw) {
//// შედეგის Map
//        Map<String, String> map = new HashMap<>();
//        if (raw == null || raw.isBlank()) return map;// // თუ მონაცემი ცარიელია, ვაბრუნებთ ცარიელ Map-ს
//// თითოეული key=value წყვილის დამუშავება
//        for (String pair : raw.split("&")) {
//            if (pair.isBlank()) continue;
//// key და value-ის გამოყოფა
//            String[] kv = pair.split("=", 2);
//// key-ის დეკოდირება
//            String key = urlDecode(kv[0]);
//// value-ის დეკოდირება (თუ არსებობს)
//            String value = (kv.length > 1) ? urlDecode(kv[1]) : "";
//// ვამატებთ Map-ში
//            if (!key.isBlank()) {
//                map.put(key, value);
//            }
//        }
//        return map;
//    }
//
//    // URL-encoded ტექსტის დეკოდირება UTF-8-ით
//    private static String urlDecode(String s) {
//        return URLDecoder.decode(s, StandardCharsets.UTF_8);
//    }
//
//    private static void sendText(HttpExchange exchange, int statusCode, String text) throws IOException {
//// ტექსტის გადაყვანა ბაიტებში UTF-8 კოდირებით
////UTF-8 არის შეთანხმება (encoding), რომელიც ამბობს:
////როგორ გადაიქცეს სიმბოლო → ბაიტებად
////A → 65
////„აიღე ეს ტექსტი და გადააქციე ბაიტებად UTF-8 წესის მიხედვით“
////UTF-8 გვჭირდება, რომ ქართული და სხვა სიმბოლოები სწორად გადაიქცეს ბაიტებად.
//        byte[] bytes = text.getBytes(StandardCharsets.UTF_8);
//// HTTP header-ის დაყენება – ტექსტი UTF-8-ით
////Content-Type ეუბნება კლიენტს:რა ტიპის მონაცემს ვუგზავნით (text/plain → უბრალო ტექსტი,
// //       text / html →HTML, application / json →JSON, image / png →picture)
//        exchange.getResponseHeaders().set("Content-Type", "text/plain; charset=UTF-8");
//// response header-ების გაგზავნა (status + body length)
//        exchange.sendResponseHeaders(statusCode, bytes.length);

    /// / response body-ში მონაცემების ჩაწერა
//        try (OutputStream os = exchange.getResponseBody()) {
//            os.write(bytes);
//        }
//    }
//    ----------------------------------------------------------------------------------------------------------------
    @Override
    public void handle(HttpExchange exchange) throws IOException {

        try {
            String method = exchange.getRequestMethod();

            if ("POST".equalsIgnoreCase(method)) {
                handlePost(exchange);
            } else {
                sendText(exchange, 405, "Method Not Allowed. Use POST.");
            }
        } catch (IOException e) {
          sendText(exchange, 500, "Internal Server Error: " + e.getMessage());
       }finally {
            exchange.close();
        }

    }

    private void handlePost(HttpExchange exchange) throws IOException {
        String body = readAll(exchange.getRequestBody());

        Map<String, String> params = parseFormLikeParams(body);


        String name = params.getOrDefault("name", "Guest");

        String city = params.getOrDefault("city", "Unknown");

        String response = "POST received\n" +
                "raw body = " + body + "\n" +
                "name = " + name + "\n" +
                "city = " + city;

        sendText(exchange, 200, response);
    }

    private static Map<String, String> parseFormLikeParams(String raw) {

        Map<String, String> map = new HashMap<>();
        if (raw == null || raw.isBlank()) return map;// // თუ მონაცემი ცარიელია, ვაბრუნებთ ცარიელ Map-ს

        for (String pair : raw.split("&")) {
            if (pair.isBlank()) continue;

            String[] kv = pair.split("=", 2);

            String key = urlDecode(kv[0]);

            String value = (kv.length > 1) ? urlDecode(kv[1]) : "";

            if (!key.isBlank()) {
                map.put(key, value);
            }
        }
        return map;
    }

    private static String urlDecode(String s) {
        return URLDecoder.decode(s, StandardCharsets.UTF_8);
    }

    private static void sendText(HttpExchange exchange, int statusCode, String text) throws IOException {

        byte[] bytes = text.getBytes(StandardCharsets.UTF_8);


        exchange.getResponseHeaders().set("Content-Type", "text/plain; charset=UTF-8");
// response header-ების გაგზავნა (status + body length)
        exchange.sendResponseHeaders(statusCode, bytes.length);

        try (OutputStream os = exchange.getResponseBody()) {
            os.write(bytes);
        }
    }

    private static String readAll(InputStream input) throws IOException {

        byte[] data = input.readAllBytes();

        return new String(data, StandardCharsets.UTF_8);
    }
}



