package com.company.quiz_service.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.company.quiz_service.domain.Quiz;
@Repository
public interface QuizDao extends JpaRepository<Quiz, Integer> {

}
