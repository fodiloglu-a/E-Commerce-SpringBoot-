package com.commerce.commerce.Core.ExceptionsConfig;

import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ExceptionsConfig {
        @ExceptionHandler(MethodArgumentNotValidException.class)
    Map<String,String> handleException(MethodArgumentNotValidException exception){
        Map<String,String> apiError=new HashMap<>();
        for (FieldError fieldError: exception.getBindingResult().getFieldErrors()){
            apiError.put(fieldError.getField(),fieldError.getDefaultMessage());
        }
        return apiError;
    }



//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    Map<String,String> handleExceptionn(MethodArgumentNotValidException exception){
//        Map<String,String> apiError=new HashMap<>();
//        for (ObjectError objectError: exception.getBindingResult().getGlobalErrors()){
//            apiError.put(objectError.getObjectName(),objectError.getDefaultMessage());
//        }
//        return apiError;
//    }
}
