package com.example.demo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.CATEGORY;
import com.example.demo.model.STUDENTRESULT;
import com.example.demo.model.SUBJECT;


@Service
public interface CategoryServices {

	void savecategory(CATEGORY category);
	
	List<CATEGORY>getcategory();

	List<SUBJECT> getsubject();
	//delete
void deletecategory(int id);
CATEGORY getCategoryById(Integer id);

List<STUDENTRESULT> getstudentresult();



		

}



