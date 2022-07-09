package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.STUDENTS;
import com.example.demo.model.USER;
import com.example.demo.services.StudentService;


@Controller
public class StudentController {
	@Autowired
	private  StudentService studentService ;
	
	@GetMapping("/student-registration")
	public String registration(Model model) {
		
		return "studentreg";
	}


	@PostMapping ("/studentaddNew")
	public String addNew(String first_name,String middle_name,String lastt_name,String address,String age,String gender,String grade,String parent_name,String phone_number,String email,String role,String username,String password) {
		studentService.saveStudent(first_name,middle_name,lastt_name,address,age,gender,grade,parent_name,phone_number,email,role,username,password);
		
return "redirect:/login";
		
		
		
	
}
	
}

