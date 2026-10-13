package com.pravin.quiz_service.controller;

import com.pravin.quiz_service.model.QuestionWrapper;
import com.pravin.quiz_service.model.Response;
import com.pravin.quiz_service.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")
public class QuizController {

    @Autowired
    QuizService quizService;

//    @PostMapping("create")
//    public ResponseEntity<String> createQuiz(@RequestParam String category, @RequestParam int numQ, @RequestParam String title){
//        return quizService.createQuiz(category, numQ, title);
//    }
//
//    @GetMapping("get/{id}")
//    public ResponseEntity<List<QuestionWrapper>> getQuestions(@PathVariable Integer id){
//        return quizService.getQuestions(id);
//    }
//
//    @PostMapping("submit/{id}")
//    public ResponseEntity<Integer> submitQuestions(@PathVariable Integer id, @RequestBody List<Response> response){
//        return quizService.calculateScore(id, response);
//    }
}
