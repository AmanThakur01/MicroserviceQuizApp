package com.company.question_service.service;

import java.util.List;

import com.company.question_service.domain.Question;
import com.company.question_service.domain.QuestionWrapper;
import com.company.question_service.domain.Response;


/**
 * This interface declares question-cases or business logic for question entity
 * @author aman
 *
 */
public interface QuestionService {
	/**
	 * add a new question in application
	 * @param q
	 */
	public String add(Question q);

	/**
	 * This method remove/delete question
	 * @param question that needed to remove
	 * @throws Exception 
	 */
	public void remove(Integer qid) ;
	/**
	 * Update question
	 * @param q contain updated value of an object
	 * @return
	 */
	public String update(Question q);
	/**
	 * this method will read question when needed to display in the quiz at runtime of exam using question id
	 * @param qid is used to fetch correct option from DB
	 */
	public Question read(Integer qId);
	/**
	 * This method return the all the question of same category for example 'java' subject/category
	 * @param category
	 * @return
	 */
	public List<Question> getQuestionByCategory(String category);

	public List<Integer> getQuestionForQuiz(String categoryName, Integer questionNum);

	public List<QuestionWrapper> getQuestionFromIds(List<Integer> ids);

	public Integer getScore(List<Response> response);
	
}
