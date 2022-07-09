package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.STUDENTS;
import com.example.demo.model.USER;
import com.example.demo.repository.StudentRepository;
import com.example.demo.repository.UserRepository;


@Service
public class StudentServiceImp implements StudentService {
	@Autowired StudentRepository studentRepo;
	@Autowired UserRepository userepo;
	
	@Override
	public void saveStudent(String first_name, String middle_name, String lastt_name, String address, String age,
			String gender, String grade, String parent_name, String phone_number, String email, String role,String username,String  password ) {
		
		USER user=new USER();
		user.setAddress(address);
		user.setEmail(email);
		user.setGender(gender);
		user.setRole(role);
		user.setPhone_number(phone_number);
		user.setUsername(username);
		user.setPassword(password);
		
		USER savedUser=userepo.save(user);
		int userId= savedUser.getId();
		
		STUDENTS student=new STUDENTS();
		student.setAge(age);
		student.setFirst_name(first_name);
		student.setGrade(grade);
		student.setLastt_name(lastt_name);
		student.setMiddle_name(middle_name);
		student.setParent_name(parent_name);
		student.setUser_id(userId);
		
		studentRepo.save(student);
	}

}
