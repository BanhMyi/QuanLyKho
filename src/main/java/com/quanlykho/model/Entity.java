package com.quanlykho.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvBindByPosition;

public class Entity {


	private Integer productId;

	private String productName;

	private Integer userId;

	private String userName;
	@NotEmpty
	private String date;
	@NotNull
	private Integer number;

	private Double price;

	public Entity() {
	}

	@Override
	public String toString() {
		return "Entity [productId=" + productId + ", productName=" + productName + ", userId=" + userId + ", userName="
				+ userName + ", date=" + date + ", number=" + number + "]";
	}


	public Entity(Integer productId, String productName, Integer userId, String userName, String date, Integer number, Double price) {
		this.productId = productId;
		this.productName = productName;
		this.userId = userId;
		this.userName = userName;
		this.date = date;
		this.number = number;
		this.price = price;
	}

	public Entity(@NotNull Integer productId, String productName, String date, Double price) {
		this.productId = productId;
		this.productName = productName;
		this.date = date;
		this.price = price;
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
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}


}
