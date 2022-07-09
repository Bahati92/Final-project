package com.example.demo.services;
import java.util.List;

import org.springframework.stereotype.Service;


import com.example.demo.model.SUBJECT;

@Service
public interface SubjectServices {
	
	void savesubject(SUBJECT subject);
	
	//delete
	void deletesubject(int id);

	SUBJECT getSubjectById(Integer id);


	List<SUBJECT> getsubject();
	
}
