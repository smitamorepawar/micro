package com.question.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.question.entities.Question;

public interface QuestionRepo extends JpaRepository<Question,Long>{

	List<Question> findByQuizId(Long quizId);
}
