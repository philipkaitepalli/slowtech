package org.jc.kp.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="Voucher")
public class Voucher {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Integer pbId;
	private Integer custId;
	private Long billId;
	//@DateTimeFormat(pattern="YYYY/MM/dd")
	private Date billDate;
	private Integer carpId;
	private String pName;
	private String pStandurdDimension;
	private String pUnitType;
	private Float pUnitPrice;
	private Integer fd;
	private Integer sd;
	private Integer nop;
	private Float ptotal;
	
	public Voucher() {}

	
	public Integer getPbId() {
		return pbId;
	}

	public void setPbId(Integer pbId) {
		this.pbId = pbId;
	}

	public Integer getCustId() {
		return custId;
	}

	public void setCustId(Integer custId) {
		this.custId = custId;
	}

	public Long getBillId() {
		return billId;
	}

	public void setBillId(Long billId) {
		this.billId = billId;
	}

	public Date getBillDate() {
		return billDate;
	}

	public void setBillDate(Date billDate) {
		this.billDate = billDate;
	}

	public Integer getCarpId() {
		return carpId;
	}

	public void setCarpId(Integer carpId) {
		this.carpId = carpId;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public String getpStandurdDimension() {
		return pStandurdDimension;
	}

	public void setpStandurdDimension(String pStandurdDimension) {
		this.pStandurdDimension = pStandurdDimension;
	}

	public String getpUnitType() {
		return pUnitType;
	}

	public void setpUnitType(String pUnitType) {
		this.pUnitType = pUnitType;
	}

	public Float getpUnitPrice() {
		return pUnitPrice;
	}

	public void setpUnitPrice(Float pUnitPrice) {
		this.pUnitPrice = pUnitPrice;
	}

	public Integer getFd() {
		return fd;
	}

	public void setFd(Integer fd) {
		this.fd = fd;
	}

	public Integer getSd() {
		return sd;
	}

	public void setSd(Integer sd) {
		this.sd = sd;
	}

	public Integer getNop() {
		return nop;
	}

	public void setNop(Integer nop) {
		this.nop = nop;
	}

	public Float getPtotal() {
		return ptotal;
	}

	public void setPtotal(Float ptotal) {
		this.ptotal = ptotal;
	}

	
	
}
