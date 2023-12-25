package com.tekle.quizapp.request;

public record AddQuestionRequest(
        String questionTitle,
        String option1,
        String option2,
        String option3,
        String option4,
        String rightAnswer,
        String difficultyLevel,
        String category
) {}
