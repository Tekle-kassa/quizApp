package com.tekle.quizapp.repository;

import com.tekle.quizapp.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question,Integer> {
    @Query(value = "SELECT * FROM question where category=?1",nativeQuery = true)
    List<Question> findQuestionByCategory(String category);
    @Query(value="SELECT * FROM  question  WHERE category=?1 ORDER BY RANDOM() LIMIT ?2",nativeQuery = true)
    List<Question>selectRandomQuestionsByCategory(String category, int numsQ);
}
