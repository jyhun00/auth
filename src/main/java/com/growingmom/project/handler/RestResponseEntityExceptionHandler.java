package com.growingmom.project.handler;

import com.growingmom.project.auth.dto.ErrorDto;
import com.growingmom.project.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;



@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(DuplicateMemberException.class)
    @ResponseBody
    protected ErrorDto conflict(RuntimeException ex, WebRequest request) {
        return new ErrorDto(HttpStatus.CONFLICT.value(), ex.getMessage());
    }


    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(NoAuthorityException.class)
    @ResponseBody
    protected ErrorDto noAuthorityException(RuntimeException ex, WebRequest request) {
        return new ErrorDto(HttpStatus.UNAUTHORIZED.value(), ex.getMessage());
    }

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(NotActivatedUserException.class)
    @ResponseBody
    protected ErrorDto notActivatedUserException(RuntimeException ex, WebRequest request) {
        return new ErrorDto(HttpStatus.UNAUTHORIZED.value(), ex.getMessage());
    }


    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(BusinessException.class)
    @ResponseBody
    protected ErrorDto badRequest(RuntimeException ex, WebRequest request) {
        return new ErrorDto(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage());
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(DataNotFoundException.class)
    @ResponseBody
    protected ErrorDto dataNotFoundRequest(RuntimeException ex, WebRequest request) {
        return new ErrorDto(HttpStatus.NOT_FOUND.value(), ex.getMessage());
    }
}