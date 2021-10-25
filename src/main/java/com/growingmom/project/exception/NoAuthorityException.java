package com.growingmom.project.exception;

public class NoAuthorityException extends BusinessException{
    public NoAuthorityException() {
        super();
    }
    public NoAuthorityException(String message, Throwable cause) {
        super(message, cause);
    }
    public NoAuthorityException(String message) {
        super(message);
    }
    public NoAuthorityException(Throwable cause) {
        super(cause);
    }
}
