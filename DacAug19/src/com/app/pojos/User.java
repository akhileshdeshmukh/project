package com.app.pojos;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="t_user")
public class User
{
  private Integer userId;
  private String name,gender,email,mobileno,address;
  @DateTimeFormat(pattern="yyyy-MM-dd")
  private Date dob;
  private String password;
  private Role role;
  private int otp;
  
  public User() {
	System.out.println("Inside parameterless constructor");
  }

  
  
public User(String password, int otp) {
	super();
	this.password = password;
	this.otp = otp;
}



public User(Integer userId, String name, String gender, String email, String mobileno, String address, Date dob,
		String password, Role role) {
	super();
	this.userId = userId;
	this.name = name;
	this.gender = gender;
	this.email = email;
	this.mobileno = mobileno;
	this.address = address;
	this.dob = dob;
	this.password = password;
	this.role = role;
}



public User(String email, String password) {
	super();
	this.email = email;
	this.password = password;
}



public User( String name, String gender, String email, String mobileno, String address, Date dob,
		String password, Role role) {
	super();
	//this.userId = userId;
	this.name = name;
	this.gender = gender;
	this.email = email;
	this.mobileno = mobileno;
	this.address = address;
	this.dob = dob;
	this.password = password;
	this.role = role;
}
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
@Column(name="u_id")
public Integer getuserId() {
	return userId;
}

public void setuserId(Integer userId) {
	this.userId = userId;
}
@Column(length=50)
public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}
@Column(length=10,nullable=false)
public String getGender() {
	return gender;
}

public void setGender(String gender) {
	this.gender = gender;
}
 
@Column(length=50 ,unique=true)
public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}
@Column(length=20,nullable=false)
public String getMobileno() {
	return mobileno;
}

public void setMobileno(String mobileno) {
	this.mobileno = mobileno;
}
 @Column(length=200)
public String getAddress() {
	return address;
}

public void setAddress(String address) {
	this.address = address;
}
@Temporal(TemporalType.DATE)
public Date getDob() {
	return dob;
}

public void setDob(Date dob) {
	this.dob = dob;
}
@Column(length=500, nullable=false)
public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}
@Enumerated(EnumType.STRING)
public Role getRole() {
	return role;
}

public void setRole(Role role) {
	this.role = role;
}

@Transient
public int getOtp() {
	return otp;
}



public void setOtp(int otp) {
	this.otp = otp;
}



@Override
public String toString() {
	return "User [userId=" + userId + ", name=" + name + ", gender=" + gender + ", email=" + email + ", mobileno="
			+ mobileno + ", address=" + address + ", dob=" + dob + ", role=" + role + "]";
}
  
  
}
