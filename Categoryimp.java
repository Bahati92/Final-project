package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.CATEGORY;
import com.example.demo.model.STUDENTRESULT;
import com.example.demo.model.SUBJECT;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.StudentResultRepository;
import com.example.demo.repository.SubjectRepository;


@Service
public class Categoryimp  implements CategoryServices{
	
@Autowired CategoryRepository categoyRepo;
@Autowired SubjectRepository subjectRepo;
@Autowired StudentResultRepository studentresultrepo;
	@Override
	public void savecategory(CATEGORY category) {
		// TODO Auto-generated method stub
		this.categoyRepo.save(category);
		
	}
	@Override
	public List<CATEGORY> getcategory() {
		// TODO Auto-generated method stub
		return categoyRepo.findAll();
	}

	@Override
	public List<SUBJECT> getsubject() {
		return subjectRepo.findAll();
	}
	
	//delete
		@Override
		public void deletecategory(int id) {
			categoyRepo.deleteById(id);
		}
		@Override
		public CATEGORY getCategoryById(Integer id) {
			
			Optional<CATEGORY> optional = categoyRepo.findById(id);
			CATEGORY category = null;
		if(optional.isPresent()) {
			category = optional.get();
					}else {
			throw new RuntimeException("type of category not found for id : :"+id);
		}
			return category	;
			}
		public List<STUDENTRESULT> getstudentresult() {
		
			return studentresultrepo.findAll();
		}
			
		
}



