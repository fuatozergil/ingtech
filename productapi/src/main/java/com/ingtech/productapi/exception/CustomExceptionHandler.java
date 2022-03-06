package com.ingtech.productapi.exception;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

/**
 * @author fuatozergil
 *
 */
@SuppressWarnings({"unchecked","rawtypes"})
@ControllerAdvice
public class CustomExceptionHandler
{   
    @ExceptionHandler(ServletRequestBindingException.class)
    public final ResponseEntity<Object> handleHeaderException(Exception ex, WebRequest request) 
    {
        List<String> details = new ArrayList<>();
        //TODO Java 11 String feature
        if(!ex.getLocalizedMessage().isBlank())
        details.add(ex.getLocalizedMessage());
        return new ResponseEntity("Bad Request" + details, HttpStatus.BAD_REQUEST);
    }
    
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) 
    {
        List<String> details = new ArrayList<>();
        //TODO Java 11 String feature
        if(!ex.getLocalizedMessage().isBlank())
        details.add(ex.getLocalizedMessage());
        return new ResponseEntity("Server Error" + details, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
