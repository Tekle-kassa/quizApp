package com.tekle.quizapp.controller;

import com.tekle.quizapp.model.Question;
import com.tekle.quizapp.request.AddQuestionRequest;
import com.tekle.quizapp.service.QuestionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {
    private final QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("allQuestions")
    public ResponseEntity<List<Question>>  getAllQuestions(){
        return questionService.getAllQuestions();
    }
    @GetMapping("category/{category}")
    public ResponseEntity<List<Question>> getQuestionsByCategory(@PathVariable("category")String category){
        return questionService.getQuestionsByCategory(category);
    }
@PostMapping("addQuestion")
    public ResponseEntity<String> addQuestion(@RequestBody AddQuestionRequest request){
//       questionService.addQuestion(request);
        return questionService.addQuestion(request);
    }
}
