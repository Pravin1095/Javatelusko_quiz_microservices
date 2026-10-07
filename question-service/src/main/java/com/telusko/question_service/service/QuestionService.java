package com.telusko.question_service.service;


import com.sun.net.httpserver.HttpsServer;
import com.telusko.question_service.model.Question;
import com.telusko.question_service.model.QuestionWrapper;
import com.telusko.question_service.model.Response;
import com.telusko.question_service.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {

    @Autowired
 QuestionRepository questionRepo;

    public ResponseEntity<List<Question>> getAllquestions(){
        try{
            return new ResponseEntity<>(questionRepo.findAll(),HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);

    }

    public ResponseEntity<List<Question>> getQuestionsByCategory(String category) {
        try{
            return new ResponseEntity<>( questionRepo.findByCategory(category), HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);

    }

    public ResponseEntity<String> addQuestion(Question question) {
        try {
            questionRepo.save(question);
            return new ResponseEntity<>("success", HttpStatus.CREATED);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>("Failed", HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<List<Integer>> getQuestionsForQuiz(String categoryName, int numQuestions) {
        List<Integer> questions = questionRepo.findRandomQuestionsByCategory(categoryName, numQuestions);
        return new ResponseEntity<>(questions, HttpStatus.OK);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuestionsById(List<Integer> questionIds) {
        List<QuestionWrapper> questionwrapper = new ArrayList<>();
        for(Integer q : questionIds){
            Question question = questionRepo.findById(q).get();
            QuestionWrapper qw = new QuestionWrapper(question.getId(), question.getQuestionTitle(),question.getOption1(),question.getOption2(),question.getOption3(),question.getOption4());
            questionwrapper.add(qw);
        }
        return new ResponseEntity<>(questionwrapper, HttpStatus.OK);
    }

    public ResponseEntity<Integer> getScore(List<Response> responses) {
        int rightAns = 0;
        for(Response res : responses){
            Question question = questionRepo.findById(res.getId()).get();
            if(res.getResponse().equals(question.getRightAnswer())){
                rightAns+=1;
            }

        }
        return new ResponseEntity<>(rightAns, HttpStatus.OK);
    }
}
