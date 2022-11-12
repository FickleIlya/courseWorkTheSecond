package com.example.courseworkthesecond.services;

import com.example.courseworkthesecond.exceptions.QuestionAlreadyExistsException;
import com.example.courseworkthesecond.exceptions.QuestionIsNullException;
import com.example.courseworkthesecond.exceptions.QuestionNotFoundException;
import com.example.courseworkthesecond.question.Question;

import java.util.Collection;

public interface QuestionService {

        Question add(String question, String answer) throws QuestionAlreadyExistsException, QuestionIsNullException;

        Question add(Question question) throws QuestionAlreadyExistsException, QuestionIsNullException;

        Question remove(Question question) throws QuestionNotFoundException, QuestionIsNullException;

        Collection<Question> getAll();

        Question getRandomQuestion();
}
