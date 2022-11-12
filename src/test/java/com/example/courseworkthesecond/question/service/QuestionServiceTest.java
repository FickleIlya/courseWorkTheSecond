package com.example.courseworkthesecond.question.service;

import com.example.courseworkthesecond.exceptions.QuestionAlreadyExistsException;
import com.example.courseworkthesecond.exceptions.QuestionIsNullException;
import com.example.courseworkthesecond.exceptions.QuestionNotFoundException;
import com.example.courseworkthesecond.question.Question;
import com.example.courseworkthesecond.repositories.QuestionRepository;
import com.example.courseworkthesecond.serviceimpls.JavaQuestionServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static com.example.courseworkthesecond.exam.constants.ExamConstants.*;

@ExtendWith(MockitoExtension.class)
public class QuestionServiceTest {

    @Mock
    private static QuestionRepository questionRepository;
    @InjectMocks
    private JavaQuestionServiceImpl questionService;

    @BeforeEach
    public void init() {
        Mockito.when(questionRepository.getQuestions()).thenReturn((List<Question>) QUESTIONS);
    }

    @Test
    public void testAddQuestionObject() throws QuestionIsNullException, QuestionAlreadyExistsException {
        Question question = new Question("QUESTION", "ANSWER");
        Assertions.assertEquals(question, questionService.add(question));
        Assertions.assertThrows(QuestionIsNullException.class, () -> questionService.add(null));
        Assertions.assertThrows(QuestionAlreadyExistsException.class, () -> questionService.add(QUESTION1));

    }

    @Test
    public void testAddQuestionStrings() throws QuestionIsNullException, QuestionAlreadyExistsException {
        String question = "QUESTION";
        String answer = "ANSWER";
        Assertions.assertEquals(new Question(question, answer), questionService.add(question, answer));

    }

    @Test
    public void testRemoveQuestion() throws QuestionIsNullException {
        Assertions.assertEquals(QUESTION1, questionService.remove(QUESTION1));
        Assertions.assertThrows(QuestionIsNullException.class, () -> questionService.remove(null));
        Assertions.assertThrows(QuestionNotFoundException.class, () -> questionService.remove(new Question("QUESTION", "ANSWER")));
    }

}