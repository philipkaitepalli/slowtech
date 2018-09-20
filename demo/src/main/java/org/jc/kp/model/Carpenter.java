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
@Table(name="Carpenter")
public class Carpenter {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
private Integer carpId;
@Length(max=10,min=10,message="{Length.carpenter.carpPhoneNo}")
@NotEmpty(message="{NotEmpty.carpenter.carpPhoneNo}")
@NumberFormat(style= Style.NUMBER)
private String carpPhoneNo;
@Size(max = 15, min = 3, message = "{Size.carpenter.FirstName}")
private String carpFirstName;
@Size(max = 15, min = 3, message = "{Size.carpenter.carpLastName}")
private String carpLastName ;
@Size(max = 20, min = 3,message = "{Size.carpenter.carpAddress }")
private String carpAddress;

public Carpenter() {}

public Carpenter(Integer carpId, String carpPhoneNo, String carpFirstName, String carpLastName, String carpAddress) {
	super();
	this.carpId = carpId;
	this.carpPhoneNo = carpPhoneNo;
	this.carpFirstName = carpFirstName;
	this.carpLastName = carpLastName;
	this.carpAddress = carpAddress;
}


public Integer getCarpId() {
	return carpId;
}
public void setCarpId(Integer carpId) {
	this.carpId = carpId;
}
public String getCarpPhoneNo() {
	return carpPhoneNo;
}
public void setCarpPhoneNo(String carpPhoneNo) {
	this.carpPhoneNo = carpPhoneNo;
}
public String getCarpFirstName() {
	return carpFirstName;
}
public void setCarpFirstName(String carpFirstName) {
	this.carpFirstName = carpFirstName;
}
public String getCarpLastName() {
	return carpLastName;
}
public void setCarpLastName(String carpLastName) {
	this.carpLastName = carpLastName;
}
public String getCarpAddress() {
	return carpAddress;
}
public void setCarpAddress(String carpAddress) {
	this.carpAddress = carpAddress;
}


}
