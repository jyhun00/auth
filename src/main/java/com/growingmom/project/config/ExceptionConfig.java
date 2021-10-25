package com.growingmom.project.config;

import com.growingmom.project.handler.RestResponseEntityExceptionHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class ExceptionConfig extends RestResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    protected ResponseEntity exception(Exception e){
        log.error("exception",e);
        e.printStackTrace();
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

}
