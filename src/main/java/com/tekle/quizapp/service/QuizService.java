package com.tekle.quizapp.service;

import com.tekle.quizapp.dao.QuestionDao;
import com.tekle.quizapp.dao.QuizDao;
import com.tekle.quizapp.model.Question;
import com.tekle.quizapp.model.QuestionWrapper;
import com.tekle.quizapp.model.Quiz;
import com.tekle.quizapp.model.ResponseRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {
    private final QuizDao quizDao;
    private final QuestionDao questionDao;

    public QuizService(QuizDao quizDao, QuestionDao questionDao) {
        this.quizDao = quizDao;
        this.questionDao = questionDao;
    }

    public ResponseEntity<String> createQuiz(String category, int numsQ, String title) {
        List<Question> questions=questionDao.selectRandomQuestionsByCategory(category,numsQ);
        Quiz quiz=new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);
        quizDao.createQuiz(quiz);
        return new ResponseEntity<>("success", HttpStatus.CREATED);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuiz(Integer quizId) {
       Optional<Quiz> quiz=quizDao.findById(quizId);
       List<Question> questions=quiz.get().getQuestions();
       List<QuestionWrapper>questionForUser=new ArrayList<>();
       for(Question q :questions){
           QuestionWrapper questionWrapper=new QuestionWrapper(q.getId(),q.getQuestionTitle(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4());
           questionForUser.add(questionWrapper);
       }
       return new ResponseEntity<>(questionForUser,HttpStatus.OK);
    }

    public ResponseEntity<Integer> submitQuiz(Integer quizId, List<ResponseRequest> requests ) {
        int score=0;
        Optional<Quiz> quiz=quizDao.findById(quizId);
        List<Question> questions=quiz.get().getQuestions();
        for(int i=0;i<requests.size();i++){
            if(requests.get(i).response().equals(questions.get(i).getRightAnswer())){
                score++;
            }
        }
        return new ResponseEntity<>(score,HttpStatus.OK);
    }
}
