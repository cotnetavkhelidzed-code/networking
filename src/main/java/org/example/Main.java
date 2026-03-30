package org.example;

import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;
import java.util.concurrent.Executor;

public class Main {
//    public static void main(String[] args) {

//        Scanner sc = new Scanner(System.in);
//
//        System.out.println("enter the number");
//        int num = sc.nextInt();
//
//        int res = 1;
//        for (int i = 1; i <= num; i++) {
//            res *= i;
//        }
//        System.out.println(res);
//------------------------------------------------------------------------------------------------------
//
//        Scanner sc = new Scanner(System.in);
//
//        System.out.println("enter the word: ");
//        String word = sc.next();
//        word.toString();
//
//        if (word.charAt(0)==word.length()-1){
//            System.out.println(true);
//            for ()
//        }
//
//
//    }

    //------------------------------------------------------------------------------------------------------

//    public static void main(String[] args) throws IOException {
//
//        InetAddress address = InetAddress.getLocalHost();
//        System.out.println(address);
//
//        InetAddress sw[] = InetAddress.getAllByName("www.google.com");
//
//        for (int i =0; i< sw.length; i++) {
//            System.out.println(sw[i]);
//        }
//
//
//        URL hp = new URL("http://www.itvet.ge/index.html");
//
//        System.out.println("Protocol: " + hp.getProtocol());
//        System.out.println("Host: " + hp.getHost());
//      System.out.println("File: " + hp.getFile());
//
//        int c;
//
//        URL hp = new URL("http://www.google.com");
//        URLConnection hpCon = hp.openConnection();
//
//        System.out.println("content type: " + hpCon.getContentType());
//
//        long len = hpCon.getContentLength();
//        if (len == -1) {
//            System.out.println("there is no information about length");
//        } else {
//            System.out.println("length: " + len);
//        }
//    }

//    public static void main(String[] args) throws Exception {
//
//        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
//
//        server.createContext("/hello", new HelloHandler());
//
//        server.start();
//    }

//    public static void main(String[] args) throws Exception {
//        HttpServer server = HttpServer.create(new InetSocketAddress(8080),0);
//
//        server.createContext("/hello", new MethodCheckHandler());
//
//        server.start();
//
//        System.out.println("Server started: localhost:8080/hello");
//


    public static void main(String[] args) throws Exception{

        HttpServer server = HttpServer.create(new InetSocketAddress(8080),0);

        server.createContext("/hello", new HelloHandler());

        server.start();

        System.out.println("server started: localhost:8080/hello");
        
    }
}










