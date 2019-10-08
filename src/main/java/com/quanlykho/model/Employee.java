package com.quanlykho.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;


@Entity
@Table(name = "employee")

public class Employee implements Serializable {
	    private static final long serialVersionUID = 1L;

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "id")
	    private Integer id;
	    @Column(name = "user_name")
	    @NotEmpty
	    private String userName;
	    @Column(name = "password")
	    private String password;
	    @Column(name = "role")
	    private String role;
	    @Column(name = "status")
	    private String status;
	    @Column(name = "raw_password")
	    @NotEmpty
	    private String rawPassword;

		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public String getUserName() {
			return userName;
		}
		public void setUserName(String userName) {
			this.userName = userName;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getRole() {
			return role;
		}
		public void setRole(String role) {
			this.role = role;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		public String getRawPassword() {
			return rawPassword;
		}
		public void setRawPassword(String rawPassword) {
			this.rawPassword = rawPassword;
		}
		public Employee() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Employee(Integer id, String userName, String password, String role, String status) {
			super();
			this.id = id;
			this.userName = userName;
			this.password = password;
			this.role = role;
			this.status = status;
		}



}
