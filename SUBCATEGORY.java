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
import javax.persistence.Transient;

@Entity
@Table(name="subcategory")
public class SUBCATEGORY {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	
	private int  id;
	private String subcategory_name;
	private String video;
	
	public String getVideo() {
		return video;
	}
	public void setVideo(String video) {
		this.video = video;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCategory_id() {
		return category_id;
	}
	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}
	
	public String getSubcategory_name() {
		return subcategory_name;
	}
	public void setSubcategory_name(String subcategory_name) {
		this.subcategory_name = subcategory_name;
	}
	public CATEGORY getCategory() {
		return category;
	}
	public void setCategory(CATEGORY category) {
		this.category = category;
	}
	
	public Set<STUDENTRESULT> getStudentResult() {
		return studentResult;
	}
	public void setStudentResult(Set<STUDENTRESULT> studentResult) {
		this.studentResult = studentResult;
	}
	
	
	public SUBCATEGORY(int id, String subcategory_name, String video, CATEGORY category, int category_id,
			 Set<STUDENTRESULT> studentResult) {
		super();
		this.id = id;
		this.subcategory_name = subcategory_name;
		this.video = video;
		this.category = category;
		this.category_id = category_id;
		
		this.studentResult = studentResult;
	}
	public SUBCATEGORY() {
		super();
		// TODO Auto-generated constructor stub
	}




	@ManyToOne(fetch=FetchType.LAZY,optional=false)
	@JoinColumn(name="category_id",insertable=false,updatable=false)
	private CATEGORY category;
	private int category_id;
	
	
	@OneToMany(mappedBy="subCategory",fetch=FetchType.LAZY,
			cascade=CascadeType.ALL)
	private Set<STUDENTRESULT> studentResult;
	
	@Transient
	 public String getVideoPath() {
       if (video == null) return null;
        
       return "video/" + id + "/" + video;
   }
	
	
}
