package com.growingmom.project.exception;

public class NotActivatedUserException extends RuntimeException{
    public NotActivatedUserException() {
        super();
    }
    public NotActivatedUserException(String message, Throwable cause) {
        super(message, cause);
    }
    public NotActivatedUserException(String message) {
        super(message);
    }
    public NotActivatedUserException(Throwable cause) {
        super(cause);
    }


}
