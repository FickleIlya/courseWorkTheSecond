package com.example.courseworkthesecond.serviceimpls;

import com.example.courseworkthesecond.exceptions.QuestionAlreadyExistsException;
import com.example.courseworkthesecond.exceptions.QuestionIsNullException;
import com.example.courseworkthesecond.exceptions.QuestionNotFoundException;
import com.example.courseworkthesecond.question.Question;
import com.example.courseworkthesecond.repositories.QuestionRepository;
import com.example.courseworkthesecond.services.QuestionService;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class JavaQuestionServiceImpl implements QuestionService {

    private final QuestionRepository questionRepository;

    public JavaQuestionServiceImpl(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }


    @Override
    public Question add(String question, String answer) {
        if (question == null || answer == null) {
            throw new QuestionIsNullException("Question and answer must not be null");
        }

        Question newQuestion = new Question(question, answer);
        if (questionRepository.getQuestions().contains(newQuestion)) {
            throw new QuestionAlreadyExistsException("Question already exists");
        }

        questionRepository.add(newQuestion);
        return newQuestion;
    }

    @Override
    public Question add(Question question) {
        if (question == null) {
            throw new QuestionIsNullException("Question must not be null");
        }

        if (questionRepository.getQuestions().contains(question)) {
            throw new QuestionAlreadyExistsException("Question already exists");
        }

        questionRepository.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        if (question == null) {
            throw new QuestionIsNullException("Question must not be null");
        }

        Question questionToDel = questionRepository.getQuestions().stream()
                .filter(q -> q.getQuestion().equals(question.getQuestion()))
                .filter(q -> q.getAnswer().equals(question.getAnswer()))
                .findFirst()
                .orElseThrow(() -> new QuestionNotFoundException("Question not found"));

        questionRepository.remove(questionToDel);

        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return questionRepository.getQuestions();
    }

    @Override
    public Question getRandomQuestion() {
        return questionRepository.getRandomQuestion();
    }
}

