package com.example.demo.services;

import org.springframework.stereotype.Service;

import com.example.demo.model.STUDENTS;



@Service
public interface StudentService {

	void saveStudent(String first_name, String middle_name, String lastt_name, String address, String age,
			String gender, String grade, String parent_name, String phone_number, String email, String role,String username,String  password);
}
