package ru.shop.exception;

public class BadOrderCountException extends RuntimeException {
    public BadOrderCountException(String message) {
        super(message);
    }
}


