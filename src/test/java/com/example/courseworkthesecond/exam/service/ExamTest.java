package com.example.courseworkthesecond.exam.service;

import com.example.courseworkthesecond.exceptions.ExamAmountException;
import com.example.courseworkthesecond.exceptions.QuestionNotFoundException;
import com.example.courseworkthesecond.question.Question;
import com.example.courseworkthesecond.serviceimpls.ExaminerServiceImpl;
import com.example.courseworkthesecond.services.QuestionService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Random;

import static com.example.courseworkthesecond.exam.constants.ExamConstants.*;

@ExtendWith(MockitoExtension.class)
public class ExamTest {

    @Mock
    private QuestionService questionService;

    @InjectMocks
    private ExaminerServiceImpl examinerService;

    @Test
    public void testGetQuestions() throws ExamAmountException, QuestionNotFoundException {

        Assertions.assertThrows(QuestionNotFoundException.class, () -> examinerService.getQuestions(1));

        Mockito.when(questionService.getAll()).thenReturn(QUESTIONS);
        Mockito.when(questionService.getRandomQuestion()).thenReturn(QUESTION1);
        Assertions.assertEquals(QUESTION1, examinerService.getQuestions(1).iterator().next());
        Assertions.assertThrows(ExamAmountException.class, () -> examinerService.getQuestions(0));
        Assertions.assertThrows(ExamAmountException.class, () -> examinerService.getQuestions(AMOUNT_OF_QUESTIONS_OUT_OF_RANGE));
    }
}
