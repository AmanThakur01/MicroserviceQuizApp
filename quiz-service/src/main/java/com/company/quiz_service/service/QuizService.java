package com.company.quiz_service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.company.quiz_service.dao.QuizDao;
import com.company.quiz_service.domain.QuestionWrapper;
import com.company.quiz_service.domain.Quiz;
import com.company.quiz_service.domain.Response;
import com.company.quiz_service.feing.QuizInterface;


@Service
public class QuizService {
	@Autowired
	QuizDao quizDao;
	
	@Autowired
	QuizInterface quizInterface;

	public ResponseEntity<String> createQuiz(String category, Integer numQ, String title) {
		List<Integer> questionId = quizInterface.getQuestionForQuiz(category, numQ).getBody();
		Quiz quiz = new Quiz();
		quiz.setTitle(title);
		quiz.setQuestionIds(questionId);
		quizDao.save(quiz);
		return new ResponseEntity<>("success", HttpStatus.CREATED);
	}

	public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {
		Quiz quiz = quizDao.findById(id).get();
		List<Integer> ids = quiz.getQuestionIds();
		
		return quizInterface.getQuestionsByIds(ids);
	}

	public ResponseEntity<Integer> calculateResult(Integer id, List<Response> res) {
		
		return quizInterface.getScore(res);
	}

}
