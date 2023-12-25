package com.tekle.quizapp.service;

import com.tekle.quizapp.model.Question;
import com.tekle.quizapp.dao.QuestionDao;
import com.tekle.quizapp.request.AddQuestionRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {
//    private final QuestionRepository questionRepository;
//private final QuestionJpaRepository questionJpaRepository;
private final QuestionDao questionDao;
    public QuestionService( QuestionDao questionDao) {
        this.questionDao = questionDao;
    }


    public ResponseEntity<List<Question>> getAllQuestions(){
        try{
            return new ResponseEntity<>(questionDao.selectAllQuestions(),HttpStatus.OK) ;
        }catch(Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST) ;
    }
    public ResponseEntity<List<Question>> getQuestionsByCategory(String category){
        try{
            return new ResponseEntity<>(questionDao.selectQuestionsByCategory(category), HttpStatus.OK) ;
        }catch(Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST) ;
    }
    public ResponseEntity<String> addQuestion(AddQuestionRequest request){
        try{
            Question question=new Question(
                    request.questionTitle(),
                    request.category(),
                    request.difficultyLevel(),
                    request.option1(),
                    request.option2(),
                    request.option3(),
                    request.option4(),
                    request.rightAnswer()
            );
            questionDao.addQuestion(question);
            return new ResponseEntity<>("success",HttpStatus.CREATED);
        }catch(Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>("no data found", HttpStatus.BAD_REQUEST) ;
    }
}
