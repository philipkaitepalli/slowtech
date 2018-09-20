package org.jc.kp.model;

import javax.persistence.Column;
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
	@Column(name = "firstName")
	@Size(max = 15, min = 3, message = "{Size.user.firstName}")
    private String firstName;
	@Column(name = "lastName")
	@Size(max = 15, min = 3, message = "{Size.user.lastName}")	
    private String lastName;
	@Column(name = "phoneNumber")
	@Length(max=10,min=10,message="{Length.user.phoneNumber}")
	@NotEmpty(message="{NotEmpty.user.phoneNumber}")
	@NumberFormat(style= Style.NUMBER)
    private String phoneNumber;
	@Column(name = "address")
    @Size(max = 30, min = 3,message = "{empty.user.address}")
    private String address;
	@Column(name = "email")
    @Size(max = 30, min = 3,message = "{Size.user.email}")
    private String email;
	@Column(name = "loginName")
    @Size(max = 15, min = 3, message = "{Size.user.LoginName}")
    private String loginName;
	@Column(name = "password")
    @Size(max = 15, min = 3, message = "{Size.user.password}")
    private String password;
	@Column(name = "roll")
    private Integer roll;
	@Column(name = "loginStatus")
    private Integer loginStatus;
	
	
	public User() {}
	
	public User(Integer userId, @Size(max = 15, min = 3, message = "{Size.user.firstName}") String firstName,
			@Size(max = 15, min = 3, message = "{Size.user.lastName}") String lastName,
			@Length(max = 10, min = 10, message = "{Length.user.phoneNumber}") @NotEmpty(message = "{NotEmpty.user.phoneNumber}") String phoneNumber,
			@Size(max = 30, min = 3, message = "{empty.user.address}") String address,
			@Size(max = 30, min = 3, message = "{Size.user.email}") String email,
			@Size(max = 15, min = 3, message = "{Size.user.loginName}") String loginName,
			@Size(max = 15, min = 3, message = "{Size.user.password}") String password, Integer roll,
			Integer loginStatus) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.email = email;
		this.loginName = loginName;
		this.password = password;
		this.roll = roll;
		this.loginStatus = loginStatus;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
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
