package com.company.question_service.rm;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.company.question_service.domain.Question;



public class QuestionRowMapper implements RowMapper<Question>{
    @Override
    public Question mapRow(ResultSet rs, int i) throws SQLException {
        Question q=new Question();
        q.setContent(rs.getString("content"));
        q.setImage(rs.getString("image"));
        q.setOption1(rs.getString("option1"));
        q.setOption2(rs.getString("option2"));
        q.setOption3(rs.getString("option3"));
        q.setOption4(rs.getString("option4"));
        q.setAnswer(rs.getString("answer"));
        q.setSubject(rs.getString("subject"));
        q.setDifficulty(rs.getString("difficulty"));
        q.setQueid(rs.getInt("queid"));
        return q;
    }    
}


