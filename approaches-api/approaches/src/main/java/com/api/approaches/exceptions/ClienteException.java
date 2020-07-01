package com.api.approaches.exceptions;

public class ClienteException extends SuperException {
    public ClienteException(String message, Object... args) {
        super(message, args);
    }
}
