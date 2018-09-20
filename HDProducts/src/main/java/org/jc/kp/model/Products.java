

/*
	CREATE TABLE `inventory`.`products` (
			  `pId` BIGINT(15) NOT NULL,
			  `pCode` VARCHAR(45) NOT NULL,
			  `pName` VARCHAR(45) NOT NULL,
			  `pCompanyName` VARCHAR(45) NOT NULL,
			  `pStandurdDimension` VARCHAR(45) NOT NULL,
			  `pUnitType` VARCHAR(45) NOT NULL,
			  `pUnitPrice` FLOAT NOT NULL,
			  `pStackUnit` VARCHAR(45) NOT NULL,
			  `pStackQuantity` BIGINT(15) NOT NULL,
			  PRIMARY KEY (`pId`));
			  
              */	



package org.jc.kp.model;
import javax.persistence.Id;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name="Products")
public class Products  {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name = "pId")
	private int pId;
	
	@Column(name = "pCode")
	@Size(max = 6, min = 2, message = "{Size.products.pCode}")
	@NotEmpty(message = "{NotEmpty.products.pCode}")
	private String pCode ;
	
	@Column(name = "pName")
	@Size(max = 20, min = 3, message = "{Size.products.pName}")
	@NotEmpty(message = "{NotEmpty.products.pName}")
	private String pName ;
	
	@Column(name = "pCompanyName")
	@Size(max = 20, min = 3, message = "{Size.products.pCompanyName}")
	@NotEmpty(message = "{NotEmpty.products.pCompanyName}")
	private String pCompanyName;
	
	@Column(name = "pStandurdDimension")	
	@Size(max = 20, min = 2, message = "{Size.products.pStandurdDimension}")
	@NotEmpty(message = "{NotEmpty.products.pStandurdDimension}")
	private String pStandurdDimension;
	
	@Column(name = "pUnitType")
	@Size(max = 10, min = 2, message = "{Size.products.pUnitType}")
	private String pUnitType;
	
	@Column(name = "pUnitPrice", nullable = false)
	@Digits(message = "{Digits.products.pUnitPrice}", fraction = 4, integer = 10)
	@NotNull(message = "{NotNull.products.pUnitPrice}")
	private Float pUnitPrice;
	
	
	@Column(name = "pSaleUnitType")
	@Size(max = 10, min = 2, message = "{Size.products.pSaleUnitType}")
	private String pSaleUnitType;
	
    @Column(name = "psaleUnitPrice", nullable = false)
	@Digits(message = "{Digits.products.psaleUnitPrice}", fraction = 4, integer = 10)
    @NotNull(message = "{NotNull.products.psaleUnitPrice}")
	private Float psaleUnitPrice;
	
	
	@Column(name = "pStackUnit")
	@Size(max = 10, min = 2, message = "{Size.products.pStackUnit}")
	@NotEmpty(message = "{NotEmpty.products.pStackUnit }")
	private String pStackUnit;
	
    @Column(name = "pStackQuantity", nullable = false)
	@Digits(integer=8, fraction=0 ,message = "{Digits.products.pStackQuantity}")
	private Long pStackQuantity;
	
	
	public Products() {}


	public Products(int pId,
			@Size(max = 6, min = 3, message = "{Size.products.pCode}") @NotEmpty(message = "{NotEmpty.products.pCode}") String pCode,
			@Size(max = 20, min = 3, message = "{Size.products.pName}") @NotEmpty(message = "{NotEmpty.products.pName}") String pName,
			@Size(max = 20, min = 3, message = "{Size.products.pCompanyName}") @NotEmpty(message = "{NotEmpty.products.pCompanyName}") String pCompanyName,
			@Size(max = 20, min = 3, message = "{Size.products.pStandurdDimension}") @NotEmpty(message = "{NotEmpty.products.pStandurdDimension}") String pStandurdDimension,
			@Size(max = 10, min = 2, message = "{Size.products.pUnitType}") String pUnitType,
			@Digits(message = "{Digits.products.pStackQuantity}", fraction = 4, integer = 10) Float pUnitPrice,
			@Size(max = 10, min = 2, message = "{Size.products.pSaleUnitType}") String pSaleUnitType,
			@Digits(message = "{Digits.products.pStackQuantity}", fraction = 4, integer = 10) Float psaleUnitPrice,
			@Size(max = 10, min = 2, message = "{Size.products.pStackUnit}") @NotEmpty(message = "{NotEmpty.products.pStackUnit }") String pStackUnit,
			@Digits(integer = 8, fraction = 0, message = "{Digits.products.pStackQuantity}") Long pStackQuantity) {
		super();
		this.pId = pId;
		this.pCode = pCode;
		this.pName = pName;
		this.pCompanyName = pCompanyName;
		this.pStandurdDimension = pStandurdDimension;
		this.pUnitType = pUnitType;
		this.pUnitPrice = pUnitPrice;
		this.pSaleUnitType = pSaleUnitType;
		this.psaleUnitPrice = psaleUnitPrice;
		this.pStackUnit = pStackUnit;
		this.pStackQuantity = pStackQuantity;
	}


	public int getpId() {
		return pId;
	}


	public void setpId(int pId) {
		this.pId = pId;
	}


	public String getpCode() {
		return pCode;
	}


	public void setpCode(String pCode) {
		this.pCode = pCode;
	}


	public String getpName() {
		return pName;
	}


	public void setpName(String pName) {
		this.pName = pName;
	}


	public String getpCompanyName() {
		return pCompanyName;
	}


	public void setpCompanyName(String pCompanyName) {
		this.pCompanyName = pCompanyName;
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


	public String getpSaleUnitType() {
		return pSaleUnitType;
	}


	public void setpSaleUnitType(String pSaleUnitType) {
		this.pSaleUnitType = pSaleUnitType;
	}


	public Float getPsaleUnitPrice() {
		return psaleUnitPrice;
	}


	public void setPsaleUnitPrice(Float psaleUnitPrice) {
		this.psaleUnitPrice = psaleUnitPrice;
	}


	public String getpStackUnit() {
		return pStackUnit;
	}


	public void setpStackUnit(String pStackUnit) {
		this.pStackUnit = pStackUnit;
	}


	public Long getpStackQuantity() {
		return pStackQuantity;
	}


	public void setpStackQuantity(Long pStackQuantity) {
		this.pStackQuantity = pStackQuantity;
	}
	
	
}



