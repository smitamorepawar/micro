package com.question.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.question.entities.Question;
import com.question.service.QuestionService;

@RestController
@RequestMapping("/question")
public class QuestionController {
	
	private QuestionService questionService;

	public QuestionController(QuestionService questionService) {
		
		this.questionService = questionService;
	}
	
	@PostMapping()
	public Question create(@RequestBody Question question)
	{
		return questionService.add(question);
	}
	
	@GetMapping()
	public List<Question> getAll()
	{
		return questionService.get();
	}
	
	@GetMapping("/{questionId}")
	public Question getOne(@PathVariable("questionId") Long questionId)
	{
		return questionService.get(questionId);
	}
	
	//get all question of specific quiz
	@GetMapping("/quiz/{quizId}")
	public List<Question> getQuestionsOfQuiz(@PathVariable("quizId") Long quizId)
	{
		return questionService.getQuestionsOfQuiz(quizId);
	}

}
