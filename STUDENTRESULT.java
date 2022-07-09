package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="studentResult")
public class STUDENTRESULT {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int  id;
	
	private String result;
	
	@ManyToOne(fetch=FetchType.LAZY,optional=false)
	@JoinColumn(name="student_id",insertable=false,updatable=false)
	private  STUDENTS student;
	private int student_id;
	
	@ManyToOne(fetch=FetchType.LAZY,optional=false)
	@JoinColumn(name="sub_category_id",insertable=false,updatable=false)
	private  SUBCATEGORY subCategory;
	private int sub_category_id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public STUDENTS getStudent() {
		return student;
	}
	public void setStudent(STUDENTS student) {
		this.student = student;
	}
	public int getStudent_id() {
		return student_id;
	}
	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}
	public SUBCATEGORY getSubCategory() {
		return subCategory;
	}
	public void setSubCategory(SUBCATEGORY subCategory) {
		this.subCategory = subCategory;
	}
	public int getSub_category_id() {
		return sub_category_id;
	}
	public void setSub_category_id(int sub_category_id) {
		this.sub_category_id = sub_category_id;
	}
	public STUDENTRESULT(int id, String result, STUDENTS student, int student_id, SUBCATEGORY subCategory,
			int sub_category_id) {
		super();
		this.id = id;
		this.result = result;
		this.student = student;
		this.student_id = student_id;
		this.subCategory = subCategory;
		this.sub_category_id = sub_category_id;
	}
	public STUDENTRESULT() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
