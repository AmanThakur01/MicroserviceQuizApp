package com.company.question_service.dao;

import java.util.List;

import com.company.question_service.domain.Question;


public interface QuestionDao {
	public void save(Question q);

	public void update(Question q);

	public void delete(Integer qid);

	public Question findById(Integer qid);

	public List<Question> findAll();

	public List<Question> findByProp(String fielName, Object value);
	
	public List<Integer> getRandomQuestionByCategory(String category,Integer qNum);
}
