package com.question.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.question.entities.Question;
import com.question.repo.QuestionRepo;

@Service
public class ServiceImpl implements QuestionService{
	
	private QuestionRepo questionRepo;
	
	

	public ServiceImpl(QuestionRepo questionRepo) {
		
		this.questionRepo = questionRepo;
	}

	@Override
	public Question add(Question question) {
	
		return questionRepo.save(question);
	}

	@Override
	public List<Question> get() {
		
		return questionRepo.findAll();
	}

	@Override
	public Question get(Long questionId) {
		
		return questionRepo.findById(questionId).orElseThrow(()->new RuntimeException("Question not found"));
	}

	@Override
	public List<Question> getQuestionsOfQuiz(Long quizId) {
	
		return questionRepo.findByQuizId(quizId);
	}

}
