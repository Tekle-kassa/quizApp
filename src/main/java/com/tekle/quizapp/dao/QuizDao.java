package com.tekle.quizapp.dao;

import com.tekle.quizapp.model.Quiz;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface QuizDao {
    void createQuiz(Quiz quiz);

    Optional<Quiz> findById(Integer quizId);
}
