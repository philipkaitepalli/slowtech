package org.jc.kp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

@Entity
@Table(name="Customer")
public class Customer {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
//	@Column(name = "customerId")
	
	private Integer customerId;
	//@Column(name = "carpId")
	 @NotNull(message = "The beside field must not be blank.")
	private Integer carpId;
	@Length(max=10,min=10,message="{Length.customer.custPhoneNo}")
	@NotEmpty(message="{NotEmpty.customer.custPhoneNo}")
	@NumberFormat(style= Style.NUMBER)
	//@Column(name = "custPhoneNo")
	private String custPhoneNo;
//	@Column(name = "custFirstName")
	@Size(max = 20, min = 3,message = "{Size.customer.custFirstName }")
	private String custFirstName;
	
	//@Column(name = "custLastName")
	@Size(max = 20, min = 3,message = "{Size.customer.custLastName }")
	private String custLastName ;
	
	//@Column(name = "custAddress")
	@Size(max = 20, min = 3,message = "{Size.customer.custAddress }")
	private String custAddress;
	
	
	public Customer() {}
	
	public Customer(Integer customerId, Integer carpId, String custPhoneNo, String custFirstName, String custLastName,
			String custAddress) {
		super();
		this.customerId = customerId;
		this.carpId = carpId;
		this.custPhoneNo = custPhoneNo;
		this.custFirstName = custFirstName;
		this.custLastName = custLastName;
		this.custAddress = custAddress;
	}
	
	
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	public Integer getCarpId() {
		return carpId;
	}
	public void setCarpId(Integer carpId) {
		this.carpId = carpId;
	}
	public String getCustPhoneNo() {
		return custPhoneNo;
	}
	public void setCustPhoneNo(String custPhoneNo) {
		this.custPhoneNo = custPhoneNo;
	}
	public String getCustFirstName() {
		return custFirstName;
	}
	public void setCustFirstName(String custFirstName) {
		this.custFirstName = custFirstName;
	}
	public String getCustLastName() {
		return custLastName;
	}
	public void setCustLastName(String custLastName) {
		this.custLastName = custLastName;
	}
	public String getCustAddress() {
		return custAddress;
	}
	public void setCustAddress(String custAddress) {
		this.custAddress = custAddress;
	}
	
	
	
	
}
