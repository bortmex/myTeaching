package com.rog.teach.httpExample.httpServer;

public class Main {
    public static void main(String[] args) {
        new Server((req, resp) ->{
            return "<html><body><h1>Hello, naive</h1>It amazing789</body></html>";
        }).bootstrap();
    }
}
