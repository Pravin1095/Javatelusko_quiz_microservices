package com.telusko.question_service.controller;


import com.telusko.question_service.model.Question;
import com.telusko.question_service.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {

    @Autowired
    QuestionService service;

    @GetMapping("allQuestions")
    public ResponseEntity<List<Question>> getAllQuestions(){

        return service.getAllquestions();
    }

    @GetMapping("category/{cat}")
    public ResponseEntity<List<Question>> getQuestionsByCategory(@PathVariable("cat") String category){
return service.getQuestionsByCategory(category);
    }


     @PostMapping("add")
    public ResponseEntity<String> addQuestion(@RequestBody Question question){

        return service.addQuestion(question);
    }


}
