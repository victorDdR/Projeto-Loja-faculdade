package com.trabalho.faculdade.impacta.config;

import com.trabalho.faculdade.impacta.product.exceptions.ProductNotFoundException;
import com.trabalho.faculdade.impacta.util.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;

@RestControllerAdvice
public class GlobalExceptHandler {

    @ExceptionHandler(ProductNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    private ErrorResponse handle(ProductNotFoundException productNotFoundException) {
        return new ErrorResponse(productNotFoundException.getMessage(), HttpStatus.NOT_FOUND.value(), Instant.now());
    }

}
