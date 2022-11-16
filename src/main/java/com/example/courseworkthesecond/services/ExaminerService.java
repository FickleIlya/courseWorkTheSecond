package com.example.courseworkthesecond.services;

import com.example.courseworkthesecond.exceptions.ExamAmountException;
import com.example.courseworkthesecond.exceptions.QuestionNotFoundException;
import com.example.courseworkthesecond.question.Question;

import java.util.Collection;

public interface ExaminerService {
    Collection<Question> getQuestions(int amount);
}
