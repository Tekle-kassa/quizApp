package com.tekle.quizapp.controller;

import com.tekle.quizapp.model.QuestionWrapper;
import com.tekle.quizapp.model.ResponseRequest;
import com.tekle.quizapp.service.QuizService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")
public class QuizController {
    private final QuizService quizService;

    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    @PostMapping("create")
    public ResponseEntity<String>  createQuiz(@RequestParam String category,@RequestParam int numsQ,@RequestParam String title){
        return quizService.createQuiz(category,numsQ,title);
    }
    @GetMapping("get/{quizId}")
    public ResponseEntity<List<QuestionWrapper>> getQuiz(@PathVariable("quizId") Integer quizId){
      return  quizService.getQuiz(quizId);
    }
    @PostMapping("submit/{quizId}")
    public ResponseEntity<Integer>submitQuiz(@PathVariable("quizId") Integer quizId,@RequestBody List<ResponseRequest> requests){
        return quizService.submitQuiz(quizId,requests);
    }
}
