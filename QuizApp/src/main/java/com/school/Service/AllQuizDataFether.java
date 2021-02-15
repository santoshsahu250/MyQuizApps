package com.school.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.school.Model.Quiz;
import com.school.Repository.QuizRepository;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;

public class AllQuizDataFether implements DataFetcher<List<Quiz>>{

	@Autowired
	QuizRepository quizRepository;
	
	@Override
	public List<Quiz> get(DataFetchingEnvironment environment) {

		return quizRepository.findAll();
	}

	
}
