package com.school.Model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;

@Table
@Entity
public class Quiz {
	
	@Id 
	private String id;
	private String question;
	private String annswer;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getAnnswer() {
		return annswer;
	}
	public void setAnnswer(String annswer) {
		this.annswer = annswer;
	}

}
