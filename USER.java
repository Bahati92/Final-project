package com.example.demo.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="users")

public class USER {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int  id;
	
	private String username;
	private String password;
	private String role;
	private String email;
	private String phone_number;
	private String address;
	private String gender;
	
	
	@OneToOne(mappedBy="user",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	private STUDENTS student;
	
	public USER() {
		super();
	}
	
	
	public USER(int id, String username, String password, String role, String email, String phone_number,
			String address, String gender,  STUDENTS student) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.role = role;
		this.email = email;
		this.phone_number = phone_number;
		this.address = address;
		this.gender = gender;
	
		this.student = student;
	}


	public STUDENTS getStudent() {
		return student;
	}

	public void setStudent(STUDENTS student) {
		this.student = student;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return username;
	}
	public void setUserName(String user_name) {
		this.username = user_name;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
}
