package com.example.courseworkthesecond.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Question can't be empty")
public class QuestionIsNullException extends Exception {
    public QuestionIsNullException(String message) {
        super(message);
    }
}
