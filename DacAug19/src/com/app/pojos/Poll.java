package com.app.pojos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="t_poll")
public class Poll 
{
   private Integer pollId;
   private String addPoll;
   private String optA;  
   private String optB;
   private String optC;
   private String optD;
   @DateTimeFormat(pattern="yyyy-MM-dd")
   private Date validUpto;
   private String status;
   //@JsonIgnore
   @JsonBackReference
   private List<PollResult> pollResult=new ArrayList<PollResult>();

   public Poll() 
   {
	System.out.println("Inside parameterless constructor");
   }

public Poll(String addPoll, String optA, String optB, String optC, String optD, Date validUpto, String status)
{
	super();
	this.addPoll = addPoll;
	this.optA = optA;
	this.optB = optB;
	this.optC = optC;
	this.optD = optD;
	this.validUpto = validUpto;
	this.status = status;
 
}

public Poll(String addPoll, String optA, String optB, String optC, String optD) {
	super();
	this.addPoll = addPoll;
	this.optA = optA;
	this.optB = optB;
	this.optC = optC;
	this.optD = optD;
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
@Column(length=500)
public String getAddPoll() {
	return addPoll;
}

public void setAddPoll(String addPoll) {
	this.addPoll = addPoll;
}
@Column(length=100)
public String getOptA() {
	return optA;
}

public void setOptA(String optA) {
	this.optA = optA;
}
@Column(length=100)
public String getOptB() {
	return optB;
}

public void setOptB(String optB) {
	this.optB = optB;
}
@Column(length=100)
public String getOptC() {
	return optC;
}

public void setOptC(String optC) {
	this.optC = optC;
}
@Column(length=100)
public String getOptD() {
	return optD;
}

public void setOptD(String optD) {
	this.optD = optD;
}

@Temporal(TemporalType.DATE)
public Date getValidUpto() {
	return validUpto;
}


public void setValidUpto(Date validUpto) {
	this.validUpto = validUpto;
}
@Column(length=50)
public String getStatus() {
	return status;
}

public void setStatus(String status) {
	this.status = status;
}

	  @OneToMany(mappedBy = "poll", cascade = CascadeType.ALL,orphanRemoval=true)
	  public List<PollResult> getPollResult() { return pollResult; }
	  
	  public void setPollResult(List<PollResult> pollResult) { this.pollResult =
	  pollResult; }
	 
	  public void addPollResult(PollResult a) {
			pollResult.add(a);
			a.setPoll(this);
		}

		public void removeAccount(PollResult a) {
			pollResult.remove(a);
			a.setPoll(null);
		}
	  
	  
@Override
public String toString() {
	return "Poll [pollId=" + pollId + ", addPoll=" + addPoll + ", optA=" + optA + ", optB=" + optB + ", optC=" + optC
			+ ", optD=" + optD + ", validUpto=" + validUpto + ", status=" + status + "]";
}
   
   
   
 }
