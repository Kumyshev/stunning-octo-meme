package com.example.octomeme.exp;

public class ComixNotFoundException extends RuntimeException {

    public ComixNotFoundException(String msg, Throwable throwable) {
        super(msg, throwable);
    }
}
