package com.alten.hotelbooking.exception;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadRequestException extends RuntimeException {

    public BadRequestException(List<String> messages) {
        super(toJsonArray(messages));
    }

    public BadRequestException(String messages) {
        super(messages);
    }

    private static String toJsonArray(List<String> messages) {
        try {
            return new ObjectMapper().writeValueAsString(messages);
        } catch (JsonProcessingException e) {
            throw new UnexpectedRequestException(e);
        }
    }
}
