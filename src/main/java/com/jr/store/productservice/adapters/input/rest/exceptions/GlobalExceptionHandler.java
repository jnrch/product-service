package com.jr.store.productservice.adapters.input.rest.exceptions;

import com.jr.store.productservice.domain.exceptions.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private final LocalDateTime timestamp = LocalDateTime.now();

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ErrorResponse handleAllExceptions(Exception exception) {
        return ErrorResponse.builder()
                .code(ErrorCatalog.GENERIC_ERROR.getCode())
                .message(ErrorCatalog.GENERIC_ERROR.getMessage())
                .details(Collections.singletonList(exception.getMessage()))
                .timestamp(timestamp)
                .build();
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ProductNotFoundException.class)
    public ErrorResponse handlePriceNotFoundException(ProductNotFoundException ex) {
        return ErrorResponse.builder()
                .code(ErrorCatalog.PRODUCT_NOT_FOUND.getCode())
                .message(ErrorCatalog.PRODUCT_NOT_FOUND.getMessage())
                .details(Collections.singletonList(ex.getMessage()))
                .timestamp(timestamp)
                .build();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ErrorResponse handleDateTimeParseException(MethodArgumentTypeMismatchException ex) {
        return ErrorResponse.builder()
                .code(ErrorCatalog.TYPE_MISMATCH_ERROR.getCode())
                .message(ErrorCatalog.TYPE_MISMATCH_ERROR.getMessage())
                .details(Collections.singletonList(ex.getMessage()))
                .timestamp(timestamp)
                .build();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErrorResponse handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error ->
                errors.put(error.getField(), error.getDefaultMessage())
        );
        return ErrorResponse.builder()
                .code(ErrorCatalog.ARGUMENT_NOT_VALID_ERROR.getCode())
                .message(ErrorCatalog.ARGUMENT_NOT_VALID_ERROR.getMessage())
                .details(errors.values().stream().toList())
                .timestamp(timestamp)
                .build();
    }
}
