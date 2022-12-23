package com.ambev.carshop.exception.handler;

import com.ambev.carshop.dto.ErrorResponseDTO;
import com.ambev.carshop.exception.DomainItemNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler(DomainItemNotFoundException.class)
    protected ResponseEntity<Object> handleDomainItemNotFoundException(DomainItemNotFoundException ex) {
        final ErrorResponseDTO response = new ErrorResponseDTO(ex.getMessage());
        return ResponseEntity.status(ex.getStatus()).body(response);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        List<FieldError> fieldErrors = ex.getFieldErrors();
        List<ErrorResponseDTO> errors = fieldErrors.stream().map(ErrorResponseDTO::new).collect(Collectors.toList());
        return ResponseEntity.badRequest().body(errors);
    }
}
