package com.tekle.quizapp.repository;

import com.tekle.quizapp.dao.QuizDao;
import com.tekle.quizapp.model.Quiz;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class QuizJpaRepository implements QuizDao {
    private final QuizRepository quizRepository;
    private final QuestionRepository questionRepository;

    public QuizJpaRepository(QuizRepository quizRepository, QuestionRepository questionRepository) {
        this.quizRepository = quizRepository;
        this.questionRepository = questionRepository;
    }

    @Override
    public void createQuiz(Quiz quiz) {
        quizRepository.save(quiz);
    }

    @Override
    public Optional<Quiz> findById(Integer quizId) {
        return quizRepository.findById(quizId);
    }
}
