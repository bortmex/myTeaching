package com.rog.teach.httpExample.httpServer;

public interface HttpHandler {
    String handle(HttpRequest request, HttpResponse response);
}
