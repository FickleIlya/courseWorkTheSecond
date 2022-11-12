package com.example.courseworkthesecond.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Question already exists")
public class QuestionAlreadyExistsException extends Exception {
    public QuestionAlreadyExistsException(String message) {
        super(message);
    }
}
