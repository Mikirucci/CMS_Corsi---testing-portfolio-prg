package com.michele.cms.exception;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice //dice a spring che questa classe gestisce tutti gli errori dei controller
public class GlobalExceptionHandler {
    
    
    @ExceptionHandler(CorsoNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleCorsoNotFouns(CorsoNotFoundException ex){
        return new ErrorResponse(404, ex.getMessage(), LocalDateTime.now());
    }


    @ExceptionHandler(CorsoAlreadyPub.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ErrorResponse handleCorsoAlreadyPub(CorsoAlreadyPub ex){
        return new ErrorResponse(409, ex.getMessage(), LocalDateTime.now());
    }


    @ExceptionHandler(CorsoNotFoundByName.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleCorsoNotFoundByName(CorsoNotFoundByName ex){
        return new ErrorResponse(404, ex.getMessage(), LocalDateTime.now());
    }


    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponse handleGenericException(Exception ex){
        return new ErrorResponse(500, "internal server error GENERIC", LocalDateTime.now());
    }

    
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleMethodArgumentNotValid(MethodArgumentNotValidException ex){
        String message = ex.getBindingResult()
            .getFieldErrors()
            .stream()
            .map(error -> error.getField() + ": " + error.getDefaultMessage())
            .collect(Collectors.joining(", "));

        return new ErrorResponse(400, message, LocalDateTime.now());
    }

}
