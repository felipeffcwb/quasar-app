package com.api.approaches.controllers;

import com.api.approaches.exceptions.ClienteException;
import com.api.approaches.exceptions.InfluencerException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(InfluencerException.class)
    public ResponseEntity handleInfluencer(HttpServletRequest httpServletRequest, InfluencerException exception) {
        ResponseEntity responseEntity = new ResponseEntity(exception, HttpStatus.BAD_REQUEST);
        return responseEntity;
    }

    @ExceptionHandler(ClienteException.class)
    public ResponseEntity handleCliente(HttpServletRequest httpServletRequest, ClienteException exception) {
        ResponseEntity responseEntity = new ResponseEntity(exception, HttpStatus.BAD_REQUEST);
        return responseEntity;
    }
}
