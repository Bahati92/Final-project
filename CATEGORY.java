package com.example.demo.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="category")
public class CATEGORY {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int  id;
	
	private String categoryname	;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSubject_id() {
		return subject_id;
	}
	public void setSubject_id(int subject_id) {
		this.subject_id = subject_id;
	}
	public String getCategoryname() {
		return categoryname;
	}
	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}
	public SUBJECT getSubject() {
		return subject;
	}
	public void setSubject(SUBJECT subject) {
		this.subject = subject;
	}
	public Set<SUBCATEGORY> getSubcategoy() {
		return subcategoy;
	}
	public void setSubcategoy(Set<SUBCATEGORY> subcategoy) {
		this.subcategoy = subcategoy;
	}
	
	public CATEGORY(int id, String categoryname, SUBJECT subject, int subject_id, Set<SUBCATEGORY> subcategoy) {
		super();
		this.id = id;
		this.categoryname = categoryname;
		this.subject = subject;
		this.subject_id = subject_id;
		this.subcategoy = subcategoy;
	}
	public CATEGORY() {
		super();
		// TODO Auto-generated constructor stub
	}

	@ManyToOne(fetch=FetchType.LAZY,optional=false)
	@JoinColumn(name="subject_id",insertable=false,updatable=false,nullable=false)
	private SUBJECT subject;
	private int subject_id;
	
	@OneToMany(mappedBy="category",fetch=FetchType.LAZY,
			cascade=CascadeType.ALL)
	private Set<SUBCATEGORY> subcategoy;
}
