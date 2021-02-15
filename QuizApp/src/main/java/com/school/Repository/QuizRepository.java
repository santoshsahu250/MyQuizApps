package com.school.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.school.Model.Quiz;

public interface QuizRepository extends JpaRepository<Quiz, String>{

}
