package com.company.question_service.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.question_service.dao.QuestionDao;
import com.company.question_service.domain.Question;
import com.company.question_service.domain.QuestionWrapper;
import com.company.question_service.domain.Response;

@Service
public class QuestionServiceImpl implements QuestionService {

	@Autowired
    private QuestionDao questionDao;
	@Override
	public String add(Question q) {
		questionDao.save(q);
		return "Question Added Successfully";
	}

	@Override
	public void remove(Integer qid)  {
		
		questionDao.delete(qid);
		
	}

	@Override
	public String update(Question q) {
		questionDao.update(q);
		return "Question Updated Successfully";
		
	}

	@Override
	public Question read(Integer qId) {
		
		return questionDao.findById(qId);
	}

	@Override
	public List<Question> getQuestionByCategory(String category) {
		
		return questionDao.findByProp("subject", category);
	}

	@Override
	public List<Integer> getQuestionForQuiz(String categoryName, Integer questionNum) {
		return questionDao.getRandomQuestionByCategory(categoryName, questionNum);
		
	}

	@Override
	public List<QuestionWrapper> getQuestionFromIds(List<Integer> ids) {
		List<QuestionWrapper> wrapper = new ArrayList<>();
		List<Question> questions= new ArrayList<>();
		for (Integer id : ids) {
			questions.add(questionDao.findById(id));
		}
		
		for (Question question : questions) {
			QuestionWrapper qWrapper = new QuestionWrapper();
			
			qWrapper.setContent(question.getContent());
			qWrapper.setImage(question.getImage());
			qWrapper.setOption1(question.getOption1());
			qWrapper.setOption2(question.getOption2());
			qWrapper.setOption3(question.getOption3());
			qWrapper.setOption4(question.getOption4());
			qWrapper.setSubject(question.getSubject());
			qWrapper.setQueid(question.getQueid());
			qWrapper.setDifficulty(question.getDifficulty());
			
			wrapper.add(qWrapper);
			
		}
		return wrapper;
	}

	@Override
	public Integer getScore(List<Response> responses) {
		int right=0;
		
		for (Response response : responses) {
			Question question= questionDao.findById(response.getId());
			
			if(response.getResponse().equals(question.getAnswer())) {
				right++;
			}
		}
		return right;
	}

}
