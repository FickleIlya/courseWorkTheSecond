package com.example.courseworkthesecond.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Exam amount is too big")
public class ExamAmountException extends RuntimeException {
    public ExamAmountException(String message) {
        super(message);
    }
}

