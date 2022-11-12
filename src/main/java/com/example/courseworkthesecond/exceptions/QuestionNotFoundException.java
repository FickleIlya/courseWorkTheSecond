package com.example.courseworkthesecond.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.NoSuchElementException;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Question not found")
public class QuestionNotFoundException extends NoSuchElementException {
    public QuestionNotFoundException(String message) {
        super(message);
    }
}

