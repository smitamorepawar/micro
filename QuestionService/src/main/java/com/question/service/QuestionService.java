package com.question.service;

import java.util.List;

import com.question.entities.Question;

public interface QuestionService {

	Question add(Question question);
	
	List<Question> get();
	
	Question get(Long questionId);
	
	List<Question> getQuestionsOfQuiz(Long quizId);
}
