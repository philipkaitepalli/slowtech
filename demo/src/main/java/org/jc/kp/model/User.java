package org.jc.kp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

@Entity
@Table(name="User")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)	
private Integer userId;
	@Size(max = 6, min = 3, message = "{Size.user.FirstName}")
private String FirstName;
	@Size(max = 6, min = 3, message = "{Size.user.LastName}")	
private String LastName;
	@Length(max=10,min=10,message="{Length.user.phoneNumber}")
	@NotEmpty(message="{NotEmpty.user.phoneNumber}")
	@NumberFormat(style= Style.NUMBER)
private String phoneNumber;
@Size(max = 6, min = 3,message = "{empty.user.Address}")
private String Address;
@Size(max = 30, min = 3,message = "{Size.user.email}")
private String email;
@Size(max = 10, min = 3, message = "{Size.user.LoginName}")
private String LoginName;
@Size(max = 10, min = 3, message = "{Size.user.password}")
private String password;
private Integer roll;
private Integer loginStatus;


public User() {
	super();
	// TODO Auto-generated constructor stub
}

public Integer getUserId() {
	return userId;
}
public void setUserId(Integer userId) {
	this.userId = userId;
}
public String getFirstName() {
	return FirstName;
}
public void setFirstName(String firstName) {
	FirstName = firstName;
}
public String getLastName() {
	return LastName;
}
public void setLastName(String lastName) {
	LastName = lastName;
}
public String getPhoneNumber() {
	return phoneNumber;
}
public void setPhoneNumber(String phoneNumber) {
	this.phoneNumber = phoneNumber;
}
public String getAddress() {
	return Address;
}
public void setAddress(String address) {
	Address = address;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getLoginName() {
	return LoginName;
}
public void setLoginName(String loginName) {
	LoginName = loginName;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public Integer getRoll() {
	return roll;
}
public void setRoll(Integer roll) {
	this.roll = roll;
}
public Integer getLoginStatus() {
	return loginStatus;
}
public void setLoginStatus(Integer loginStatus) {
	this.loginStatus = loginStatus;
}
}
