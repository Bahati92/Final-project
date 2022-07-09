package com.example.demo.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="subject")
public class SUBJECT {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int  id;
	
	private String subjectname;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSubjectname() {
		return subjectname;
	}
	public void setSubjectname(String subjectname) {
		this.subjectname = subjectname;
	}
	public Set<CATEGORY> getCategory() {
		return category;
	}
	public void setCategory(Set<CATEGORY> category) {
		this.category = category;
	}
	
	

	public SUBJECT(int id, String subjectname, Set<STUDENTS> student, Set<CATEGORY> category) {
		super();
		this.id = id;
		this.subjectname = subjectname;
		this.category = category;
	}
	
	public SUBJECT() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	@OneToMany(mappedBy="subject",fetch=FetchType.LAZY)
	private Set<CATEGORY> category;
	
	
	

}
