package com.company.question_service.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.company.question_service.domain.Question;
import com.company.question_service.rm.IdRowMapper;
import com.company.question_service.rm.QuestionRowMapper;

@Repository
public class QuestionDaoImpl extends BaseDao implements QuestionDao {

	@Override
	public void save(Question q) {
		String sql = "INSERT INTO question(`content`, `image`, `option1`, `option2`, `option3`, `option4`, `answer`, `subject`, `difficulty`)"
				+ " VALUES(:content, :image, :option1, :option2, :option3, :option4, :answer, :subject,:difficulty)";
		MapSqlParameterSource ps = new MapSqlParameterSource();
		ps.addValue("content", q.getContent());
		ps.addValue("image", q.getImage());
		ps.addValue("option1", q.getOption1());
		ps.addValue("option2", q.getOption2());
		ps.addValue("option3", q.getOption3());
		ps.addValue("option4", q.getOption4());
		ps.addValue("answer", q.getAnswer());
		ps.addValue("subject", q.getSubject());
		ps.addValue("difficulty", q.getDifficulty());

		npjt.update(sql, ps);
	}

	@Override
	public void update(Question q) {
		String sql = "UPDATE question SET content=:content," + "image=:image," + "email=:email," + "option1=:option1,"
				+ "option2=:option2," + "option3=:option3," + "option4=:option4," + "answer=:answer,"
				+ "subject=:subject," + "difficulty=:difficulty" + "WHERE queid=:que_id";
		Map<String, Object> m = new HashMap<String, Object>();
		m.put("content", q.getContent());
		m.put("image", q.getImage());
		m.put("option1", q.getOption1());
		m.put("option2", q.getOption2());
		m.put("option3", q.getOption3());
		m.put("option4", q.getOption4());
		m.put("answer", q.getAnswer());
		m.put("subject", q.getSubject());
		m.put("difficulty", q.getDifficulty());
		m.put("que_id", q.getQueid());
		npjt.update(sql, m);

	}

	@Override
	public void delete(Integer qid) {
		String sql = "DELETE FROM question WHERE queid=?";
		jt.update(sql, qid);

	}

	@Override
	public Question findById(Integer qid) {
		String sql = "SELECT * FROM question WHERE queid = " + qid;
		return jt.queryForObject(sql, new QuestionRowMapper());
	}

	@Override
	public List<Question> findAll() {
		String sql = "SELECT * FROM question";
		return jt.query(sql, new QuestionRowMapper());
	}

	@Override
	public List<Question> findByProp(String fielName, Object value) {
		String sql = "SELECT * FROM question WHERE " + fielName + "=?";
		return jt.query(sql, new QuestionRowMapper(), value);
	}

	@Override
	public List<Integer> getRandomQuestionByCategory(String category, Integer qNum) {
		String sql = "SELECT q.queid FROM question q WHERE q. subject = '"+category+"' ORDER BY RAND() LIMIT " + qNum;
		return jt.query(sql, new IdRowMapper());
	}

}
