package org.jc.kp.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Entity;
import javax.persistence.Table;
@Entity
@Table(name="DayWiseBills")
public class DayWiseBills {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Long Id;
	private Long billId;
	private Integer customerId;
	private Integer carpId;
	private Float billTotal;
	private Float paidAmount;
	private String date;
	
	public DayWiseBills(){}
	
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public Long getBillId() {
		return billId;
	}
	public void setBillId(Long billId) {
		this.billId = billId;
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
	public Float getBillTotal() {
		return billTotal;
	}
	public void setBillTotal(Float billTotal) {
		this.billTotal = billTotal;
	}
	public Float getPaidAmount() {
		return paidAmount;
	}
	public void setPaidAmount(Float paidAmount) {
		this.paidAmount = paidAmount;
	}
	public String getDate() {
		 return date;
	}
	public void setDate(String date) {
		this.date = date;
	}

}
