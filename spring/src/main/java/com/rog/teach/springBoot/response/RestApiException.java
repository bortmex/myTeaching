package com.rog.teach.springBoot.response;

public class RestApiException extends RuntimeException{
    public RestApiException(String message){
        super(message);
    }
}
