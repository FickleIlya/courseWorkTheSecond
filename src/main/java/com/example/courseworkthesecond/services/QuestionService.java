package com.example.courseworkthesecond.services;

import com.example.courseworkthesecond.exceptions.QuestionAlreadyExistsException;
import com.example.courseworkthesecond.exceptions.QuestionIsNullException;
import com.example.courseworkthesecond.exceptions.QuestionNotFoundException;
import com.example.courseworkthesecond.question.Question;

import java.util.Collection;

public interface QuestionService {

        Question add(String question, String answer);

        Question add(Question question);

        Question remove(Question question);

        Collection<Question> getAll();

        Question getRandomQuestion();
}
