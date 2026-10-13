package com.pravin.quiz_service.service;

import com.pravin.quiz_service.model.Question;
import com.pravin.quiz_service.model.QuestionWrapper;
import com.pravin.quiz_service.model.Quiz;
import com.pravin.quiz_service.model.Response;
import com.pravin.quiz_service.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {

    @Autowired
    QuizRepository quizRepo;

//
//    public ResponseEntity<String> createQuiz(String category, int numQ, String title){
//        List<Question> questions = questionRepo.findRandomQuestionsByCategory(category, numQ);
//
//        Quiz quiz = new Quiz();
//        quiz.setTitle(title);
//        quiz.setQuestions(questions);
//        quizRepo.save(quiz);
//
//        return new ResponseEntity<>("success", HttpStatus.CREATED);
//    }

//    public ResponseEntity<List<QuestionWrapper>> getQuestions(Integer id) {
//        Optional<Quiz> quiz = quizRepo.findById(id);
//        List<Question> questionsFromDb = quiz.get().getQuestions();
//        List<QuestionWrapper> questionForUser = new ArrayList<>();
//        for(Question q : questionsFromDb){
//            QuestionWrapper qw = new QuestionWrapper(q.getId(),q.getQuestionTitle(),q.getOption1(), q.getOption2(),q.getOption3(),q.getOption4());
//            questionForUser.add(qw);
//        }
//        return new ResponseEntity<>(questionForUser, HttpStatus.OK);
//    }
//
//    public ResponseEntity<Integer> calculateScore(Integer id, List<Response> response) {
//        Quiz quiz = quizRepo.findById(id).get();
//        List<Question> questions = quiz.getQuestions();
//        int right = 0;
//        int i=0;
//        for(Response r : response ){
//            if(r.getResponse().equals(questions.get(i).getRightAnswer())){
//                right++;
//            }
//            i++;
//
//        }
//        return  new ResponseEntity<>(right,HttpStatus.OK);
//    }
}
