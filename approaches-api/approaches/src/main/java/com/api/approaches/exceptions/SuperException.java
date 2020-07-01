package com.api.approaches.exceptions;

public class SuperException extends Exception {
    private final Object[] args;

    public SuperException(String message) {
        super(message);
        this.args = null;
    }

    public SuperException(String message, Object... args) {
        super(message);
        this.args = args;
    }

    public Object[] getArgs() {
        return args;
    }

}
