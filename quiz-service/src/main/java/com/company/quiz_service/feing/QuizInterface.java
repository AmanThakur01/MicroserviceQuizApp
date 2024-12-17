package com.company.quiz_service.feing;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.company.quiz_service.domain.QuestionWrapper;
import com.company.quiz_service.domain.Response;


@FeignClient("QUESTION-SERVICE")
public interface QuizInterface {
	@GetMapping("/generate")
	public ResponseEntity<List<Integer>> getQuestionForQuiz(@RequestParam String categoryName, @RequestParam Integer questionNum);
	
	@PostMapping("/getQuestions")
	public ResponseEntity<List<QuestionWrapper>> getQuestionsByIds(@RequestBody List<Integer> ids);
	
	@PostMapping("/getScore")
	public ResponseEntity<Integer> getScore(@RequestBody List<Response> response);
}
