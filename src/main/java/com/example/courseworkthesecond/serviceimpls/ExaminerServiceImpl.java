package com.example.courseworkthesecond.serviceimpls;

import com.example.courseworkthesecond.exceptions.ExamAmountException;
import com.example.courseworkthesecond.exceptions.QuestionNotFoundException;
import com.example.courseworkthesecond.question.Question;
import com.example.courseworkthesecond.services.ExaminerService;
import com.example.courseworkthesecond.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.util.ArrayList;
import java.util.Collection;

@Service
@SessionScope
public class ExaminerServiceImpl implements ExaminerService {


    private final QuestionService questionService;
    private final Collection<Question> questions;

    @Autowired
    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
        this.questions = new ArrayList<>();
    }

    @Override
    public Collection<Question> getQuestions(int amount) throws ExamAmountException, QuestionNotFoundException {
        if (questionService.getAll().isEmpty()) {
            throw new QuestionNotFoundException("There are no questions in repository");
        }
        if (amount > questionService.getAll().size() || amount <= 0) {
            throw new ExamAmountException("Amount of questions must be between 1 and " + questionService.getAll().size());
        }

        Question question;
        while (questions.size() < amount) {
            question = questionService.getRandomQuestion();
            System.out.println(question);
            if (!questions.contains(question)) {
                questions.add(question);
            }
        }
        return questions;
    }
}
