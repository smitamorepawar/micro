package com.quiz.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.quiz.entities.Question;

@FeignClient(url="http://localhost:8484",value="Question-Client")
public interface QuestionClient {

	@GetMapping("/question/quiz/{quizId}")
	List<Question> getQuestionOfQuiz(@PathVariable("quizId") Long quizId);
}
