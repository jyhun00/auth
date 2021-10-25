package com.growingmom.project.exception;

public class DataNotFoundException extends BusinessException{
    public DataNotFoundException() {
        super();
    }
    public DataNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
    public DataNotFoundException(String message) {
        super(message);
    }
    public DataNotFoundException(Throwable cause) {
        super(cause);
    }
}
