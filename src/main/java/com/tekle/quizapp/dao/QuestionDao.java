package com.tekle.quizapp.dao;

import com.tekle.quizapp.model.Question;
import com.tekle.quizapp.model.Quiz;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface QuestionDao {
List<Question>selectAllQuestions();
List<Question>selectQuestionsByCategory(String category);
void addQuestion(Question question);
List<Question> selectRandomQuestionsByCategory(String category, int numsQ);
Optional<Question> findById(Integer questionId);
}
