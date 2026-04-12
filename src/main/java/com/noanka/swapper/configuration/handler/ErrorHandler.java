package com.noanka.swapper.configuration.handler;

import com.noanka.swapper.data.constant.BusinessException;
import com.noanka.swapper.data.http.response.ResponseBase;
import org.apache.commons.lang3.NotImplementedException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorHandler {
    @ExceptionHandler
    public ResponseEntity<ResponseBase> handleAnyException(Exception ex) {
        throw new NotImplementedException();
    }

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ResponseBase> handleValidationErrors(BusinessException ex){
        throw new NotImplementedException();
    }
}
