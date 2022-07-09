package com.example.demo.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="students")
public class STUDENTS {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private int  id;
	private String first_name;
	private String middle_name;
	private String lastt_name;
	private String age;
	private String grade;
	private String parent_name;
	
	
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getMiddle_name() {
		return middle_name;
	}
	public void setMiddle_name(String middle_name) {
		this.middle_name = middle_name;
	}
	public String getLastt_name() {
		return lastt_name;
	}
	public void setLastt_name(String lastt_name) {
		this.lastt_name = lastt_name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getParent_name() {
		return parent_name;
	}
	public void setParent_name(String parent_name) {
		this.parent_name = parent_name;
	}
	
	
	

	public USER getUser() {
		return user;
	}
	public void setUser(USER user) {
		this.user = user;
	}
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	

	
	public STUDENTS(int id, String first_name, String middle_name, String lastt_name, String age, String grade,
			String parent_name,  USER user, int user_id) {
		super();
		this.id = id;
		this.first_name = first_name;
		this.middle_name = middle_name;
		this.lastt_name = lastt_name;
		this.age = age;
		this.grade = grade;
		this.parent_name = parent_name;
		
		this.user = user;
		this.user_id = user_id;
	}
	public STUDENTS() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="user_id",insertable=false,updatable=false)
	private USER user;
	private int user_id;
	
	
}
