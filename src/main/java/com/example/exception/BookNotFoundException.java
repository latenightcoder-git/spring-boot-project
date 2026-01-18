package com.example.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// This tells Spring to automatically return 404 NOT FOUND when this is thrown
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class BookNotFoundException extends ResourceNotFoundException {
    public BookNotFoundException(String message) {
        super(message);
    }
}
