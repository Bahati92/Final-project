package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.demo.model.SUBJECT;
import com.example.demo.repository.SubjectRepository;

@Service
public class SubjectServiceImpl implements SubjectServices {
	@Autowired SubjectRepository subjectRepo;
	
	@Override
	public void savesubject(SUBJECT subject) {
		this.subjectRepo.save(subject);
	}
	@Override
	public List<SUBJECT> getsubject(){
		return subjectRepo.findAll();
        	
        }
	//delete
			@Override
			public void deletesubject(int id) {
				subjectRepo.deleteById(id);
			}
			
			@Override
			public SUBJECT getSubjectById(Integer id) {
				
				Optional<SUBJECT> optional = subjectRepo.findById(id);
			SUBJECT subject = null;
			if(optional.isPresent()) {
				subject = optional.get();
						}else {
				throw new RuntimeException("type of subject not found for id : :"+id);
			}
				return subject	;
				}
			
}
