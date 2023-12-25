package com.tekle.quizapp.repository;

import com.tekle.quizapp.model.Question;
import com.tekle.quizapp.dao.QuestionDao;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class QuestionJpaRepository implements QuestionDao {
    private final QuestionRepository questionRepository;

    public QuestionJpaRepository(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Override
    public List<Question> selectAllQuestions() {
        return questionRepository.findAll();
    }

    @Override
    public List<Question> selectQuestionsByCategory(String category) {
        return questionRepository.findQuestionByCategory(category);
    }

    @Override
    public void addQuestion(Question question) {
        questionRepository.save(question);
    }

    @Override
    public List<Question> selectRandomQuestionsByCategory(String category, int numsQ) {
       return questionRepository.selectRandomQuestionsByCategory(category,numsQ);
    }

    @Override
    public Optional<Question> findById(Integer questionId) {
        return questionRepository.findById(questionId);
    }
}
