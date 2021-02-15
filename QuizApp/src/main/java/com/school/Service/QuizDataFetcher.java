package com.school.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.school.Model.Quiz;
import com.school.Repository.QuizRepository;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;

@Component
public class QuizDataFetcher implements DataFetcher<Quiz>{

	@Autowired
	QuizRepository quizRepository;
	
	
	@Override
	public Quiz get(DataFetchingEnvironment environment) {
		
	String id =	environment.getArgument("id");
		return quizRepository.findById(id).get();
	}

}
