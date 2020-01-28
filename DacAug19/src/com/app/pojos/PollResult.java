package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="t_poll_result")
public class PollResult 
{
  private Integer pollId;
  private String answer;
  private String ip;
  private Poll poll;
  
  public PollResult() {
	System.out.println("Inside parameterless constructor");
}

  
  
public PollResult(String answer) {
	super();
	this.answer = answer;
}



public PollResult(String answer, String ip) {
	super();
	this.answer = answer;
	this.ip = ip;
}
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
@Column(name="p_id")
public Integer getPollId() {
	return pollId;
}

public void setPollId(Integer pollId) {
	this.pollId = pollId;
}
@Column(length=40)
public String getAnswer() {
	return answer;
}

public void setAnswer(String answer) {
	this.answer = answer;
}
@Column(length=40)
public String getIp() {
	return ip;
}

public void setIp(String ip) {
	this.ip = ip;
}

	  @ManyToOne
	  
	  @JoinColumn(name = "poll_id") public Poll getPoll() { return poll; }
	  
	  public void setPoll(Poll poll) { this.poll = poll; }
	 
@Override
public String toString() {
	return "PollResult [pollId=" + pollId + ", answer=" + answer + ", ip=" + ip + "]";
}
  
	
}
