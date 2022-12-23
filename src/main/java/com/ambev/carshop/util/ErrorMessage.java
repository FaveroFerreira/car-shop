package com.ambev.carshop.util;

import org.springframework.http.HttpStatus;

public enum ErrorMessage implements ApiMessage {
    BRAND_ID_NOT_FOUND("brand.id.not.found", HttpStatus.NOT_FOUND);

    private final String key;
    private final HttpStatus status;

    ErrorMessage(String key, HttpStatus status) {
        this.key = key;
        this.status = status;
    }

    @Override
    public String getMessage(String... args) {
        return MessageUtil.getMessage(this.key, args);
    }

    @Override
    public HttpStatus getStatus() {
        return this.status;
    }
}
