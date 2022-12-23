package com.ambev.carshop.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.springframework.validation.FieldError;

import java.time.Instant;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorResponseDTO {

    private final String message;
    private final Instant timestamp;
    private final String field;

    public ErrorResponseDTO(String message, String field) {
        this.message = message;
        this.timestamp = Instant.now();
        this.field = field;
    }

    public ErrorResponseDTO(String message) {
        this.message = message;
        this.timestamp = Instant.now();
        this.field = null;
    }

    public ErrorResponseDTO(FieldError fieldError) {
        this.message = fieldError.getDefaultMessage();
        this.field = fieldError.getField();
        this.timestamp = null;
    }

}
