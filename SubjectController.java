package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.example.demo.model.SUBJECT;

import com.example.demo.services.SubjectServices;

@Controller
public class SubjectController {
	
	@Autowired
	SubjectServices subjectService;
	
	@GetMapping ("/subject")
	public String getsubj(Model model) {
		List<SUBJECT> subje=subjectService.getsubject();
		model.addAttribute("oursubj", subje);
		return "subjectpage";
	}
	
	@PostMapping("/addSubject")
	public String saveSubject(@ModelAttribute("subject") SUBJECT subject)
	{
		subjectService.savesubject(subject);
	return "redirect:/subject";
	}
	//delete
	@RequestMapping(value="/deletesubject",method= {RequestMethod.DELETE, RequestMethod.GET})
			public String deletesubject(int id) {
				subjectService.deletesubject(id);
				return "redirect:/subject";
			}
	@GetMapping("/updatesubject/{id}")
	public String subje(@PathVariable (value="id") int id,Model model){
	SUBJECT subject = subjectService.getSubjectById(id);
		  	model.addAttribute("subject", subject);
		   	return "updatesubject";		    	 
		   } 
}
