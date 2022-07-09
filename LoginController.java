package com.example.demo.controller;
import java.util.List;
import java.util.Optional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dto.Login;
import com.example.demo.model.CATEGORY;
import com.example.demo.model.STUDENTRESULT;
import com.example.demo.model.STUDENTS;
import com.example.demo.model.SUBCATEGORY;
import com.example.demo.model.USER;
import com.example.demo.repository.StudentRepository;
import com.example.demo.services.CategoryServices;
import com.example.demo.services.LoginServices;
import com.example.demo.services.SubcaregoryService;
import com.example.demo.services.UserService;

@Controller
public class LoginController {
	@Autowired LoginServices loginservice;
	@Autowired CategoryServices categoryService;
	@Autowired StudentRepository studrepo;
	@Autowired
	SubcaregoryService subService;

@PostMapping("/login")
	public String login(@ModelAttribute("login") Login req, Model model) {

	List<USER> login = loginservice.login(req.getUsername(), req.getPassword());
		USER u = new USER();
	for(USER us:login) {
	u.setRole(us.getRole());
	u.setId(us.getId());
	u.setStudent(us.getStudent());
	
	}		if(login.size()>0) {
		if(u.getRole().equals("Admin")) {
			return"redirect:/dash";
		}if(u.getRole().equals("Student")) {
			int id=u.getId();
			STUDENTS student=u.getStudent();
			System.out.print(student);
			model.addAttribute("student",student);
			
			List<SUBCATEGORY> subcategory=subService.getSubCategory();
			model.addAttribute("subcat",subcategory);
			
			List<CATEGORY> cate=categoryService.getcategory();
			model.addAttribute("ourcategory", cate);
			
			List<STUDENTRESULT> sture=categoryService.getstudentresult();
			model.addAttribute("sture", sture);
			return "subcategorylist";
		}else {
			return "redirect:/index";
		}
		}
		return "redirect:/loginPage";
}
@GetMapping("/loginPage")
public String getlogin(){
	return "login";
}
}
		
		

