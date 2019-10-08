package com.quanlykho.model;

public class DTObject {

	private Integer productId;
	private String productName;
	private Integer employeeId;
	private String emploeeName;
	private Integer number;
	private String date;
	public DTObject(Integer productId, String productName, Integer employeeId, String emploeeName, Integer number,
			String date) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.employeeId = employeeId;
		this.emploeeName = emploeeName;
		this.number = number;
		this.date = date;
	}
	public DTObject() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Integer getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmploeeName() {
		return emploeeName;
	}
	public void setEmploeeName(String emploeeName) {
		this.emploeeName = emploeeName;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}


}
