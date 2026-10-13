package com.pravin.quiz_service.model;

import lombok.Data;

@Data
public class QuizDto {
    String category;
    int numQ;
    String title;
}
