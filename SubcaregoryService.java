package com.example.demo.services;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.model.CATEGORY;
import com.example.demo.model.SUBCATEGORY;
import com.example.demo.model.SUBJECT;

@Service
public interface SubcaregoryService {

	String create(String name, int subcategory_id, MultipartFile videoFile) throws IOException;

	List<CATEGORY> getCategory();

	List<SUBCATEGORY> getSubCategory();

	Optional<SUBCATEGORY> getById(int id);
	//delete
	void deleteSubcategory(Integer id);
		

		SUBCATEGORY getSubcategoryById(Integer id);

	

	
		
	
	
}
