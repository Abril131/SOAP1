package com.example.apihex.Ordenes.Infrestructure.Exceptions;

public class NotFoundException extends RuntimeException{
    public NotFoundException(String message) {
        super(message);
    }
}
