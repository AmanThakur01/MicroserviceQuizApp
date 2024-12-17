package com.company.question_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.company.question_service.domain.Question;
import com.company.question_service.domain.QuestionWrapper;
import com.company.question_service.domain.Response;
import com.company.question_service.service.QuestionService;


@RestController
public class QuestionController {
	@Autowired
	QuestionService questionService;

	@PostMapping("/add")
	public ResponseEntity<String> addQuestion(@RequestBody Question que) {
		return ResponseEntity.ok(questionService.add(que));
	}

	@GetMapping("/category/{category}")
	public ResponseEntity<List<Question>> getQuestionByCategory(@PathVariable String category) {
		return ResponseEntity.ok(questionService.getQuestionByCategory(category));
	}

	@GetMapping("/remove/{qid}")
	public void removeQuestion(@PathVariable Integer qid) {

		questionService.remove(qid);

	}

	@PostMapping("/update")
	public ResponseEntity<String> updateQuestion(@RequestBody Question que) {
		return ResponseEntity.ok(questionService.update(que));

	}

	@GetMapping("/read/{qid}")
	public ResponseEntity<Question> readQuestion(@PathVariable Integer qid) {

		return ResponseEntity.ok(questionService.read(qid));
	}
	@GetMapping("/generate")
	public ResponseEntity<List<Integer>> getQuestionForQuiz(@RequestParam String categoryName, @RequestParam Integer questionNum){
		return ResponseEntity.ok(questionService.getQuestionForQuiz(categoryName,questionNum));
	}
	@PostMapping("/getQuestions")
	public ResponseEntity<List<QuestionWrapper>> getQuestionsByIds(@RequestBody List<Integer> ids)
	{
		
		return ResponseEntity.ok(questionService.getQuestionFromIds(ids));
	}
	@PostMapping("/getScore")
	public ResponseEntity<Integer> getScore(@RequestBody List<Response> response){
		return ResponseEntity.ok(questionService.getScore(response));
	}
}
