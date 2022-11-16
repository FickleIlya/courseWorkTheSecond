package com.example.courseworkthesecond.exam.constants;

import com.example.courseworkthesecond.question.Question;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ExamConstants {

    public static final Question QUESTION1 = new Question("Question1", "Answer1");
    public static final Question QUESTION2 = new Question("Question2", "Answer2");
    public static final Question QUESTION3 = new Question("Question3", "Answer3");
    public static final Question QUESTION4 = new Question("Question4", "Answer4");
    public static final Question QUESTION5 = new Question("Question5", "Answer5");
    public static final Question QUESTION6 = new Question("Question6", "Answer6");
    public static final Question QUESTION7 = new Question("Question7", "Answer7");
    public static final List<Question> QUESTIONS = new ArrayList<>(List.of(QUESTION1, QUESTION2, QUESTION3, QUESTION4, QUESTION5, QUESTION6, QUESTION7));
    public static final int AMOUNT_OF_QUESTIONS = QUESTIONS.size();
    public static final int AMOUNT_OF_QUESTIONS_OUT_OF_RANGE = 1000;
}
