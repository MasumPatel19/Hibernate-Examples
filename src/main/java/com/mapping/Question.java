package com.mapping;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Question {

	@Id
	private int queId;
	private String quetion;

	@OneToMany(mappedBy = "question")
	private List<Answer> answer;

//	@OneToOne
//	private Answer answer;

	public int getQueId() {
		return queId;
	}

	public void setQueId(int queId) {
		this.queId = queId;
	}

	public String getQuetion() {
		return quetion;
	}

	public void setQuetion(String quetion) {
		this.quetion = quetion;
	}

//	public Answer getAnswer() {
//		return answer;
//	}
//
//	public void setAnswer(Answer answer) {
//		this.answer = answer;
//	}
//
//	public Question(int queId, String quetion, Answer answer) {
//		super();
//		this.queId = queId;
//		this.quetion = quetion;
//		this.answer = answer;
//	}

	public List<Answer> getAnswer() {
		return answer;
	}

	public void setAnswer(List<Answer> answer) {
		this.answer = answer;
	}

	public Question(int queId, String quetion, List<Answer> answer) {
		super();
		this.queId = queId;
		this.quetion = quetion;
		this.answer = answer;
	}

	public Question() {
		super();
	}

	@Override
	public String toString() {
		return "Question [queId=" + queId + ", quetion=" + quetion + ", answer=" + answer + "]";
	}

}
