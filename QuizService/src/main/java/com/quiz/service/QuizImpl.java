package com.quiz.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.entities.Quiz;
import com.quiz.repo.QuizRepo;

@Service
public class QuizImpl implements QuizService {

    
    private QuizRepo quizRepo;
    
    private QuestionClient questionClient;
    
    

    public QuizImpl(QuizRepo quizRepo, QuestionClient questionClient) {
		this.quizRepo = quizRepo;
		this.questionClient = questionClient;
	}

	@Override
    public Quiz add(Quiz quiz) {
        return quizRepo.save(quiz);
    }

    @Override
    public List<Quiz> get() {
        List<Quiz>  quizzes= quizRepo.findAll();
        List<Quiz> newQuizList=quizzes.stream().map(quiz->{
        	quiz.setQuestions(questionClient.getQuestionOfQuiz(quiz.getId()));
        	return quiz;
        }).collect(Collectors.toList());
              return newQuizList;
    }

    @Override
    public Quiz get(Long id) {

        Quiz quiz= quizRepo.findById(id).orElseThrow(() -> new RuntimeException("Quiz not found"));
         quiz.setQuestions(questionClient.getQuestionOfQuiz(quiz.getId()));
         return quiz;
    }

}
