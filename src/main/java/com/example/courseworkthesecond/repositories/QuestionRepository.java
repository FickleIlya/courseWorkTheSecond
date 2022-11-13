package com.example.courseworkthesecond.repositories;

import com.example.courseworkthesecond.question.Question;
import org.springframework.stereotype.Repository;
import org.springframework.web.context.annotation.SessionScope;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Repository
@SessionScope
public class QuestionRepository {

    private final List<Question> questions;
    private final Random random;

    public QuestionRepository() {
        this.random = new Random();
        this.questions = new ArrayList<>();
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void add(String question, String answer) {
        questions.add(new Question(question, answer));
    }
    public void add(Question question) {
        questions.add(question);
    }

    public void remove(Question question) {
        questions.remove(question);
    }

    public Question getRandomQuestion() {
        return questions.get(random.nextInt(questions.size()));
    }
}
