package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.model.CATEGORY;
import com.example.demo.model.STUDENTRESULT;
import com.example.demo.model.STUDENTS;
import com.example.demo.model.SUBJECT;
import com.example.demo.repository.StudentRepository;
import com.example.demo.services.CategoryServices;
import com.example.demo.services.SubjectServices;

@Controller
public class CategoryController {
	@Autowired
	CategoryServices categoryService;
	@Autowired StudentRepository studRepo;
	
	@GetMapping ("/category")
	public String getcate(Model model) {
		List<CATEGORY> cate=categoryService.getcategory();
		model.addAttribute("ourcategory", cate);
		
		List<SUBJECT> sub=categoryService.getsubject();
		model.addAttribute("oursubject", sub);
		
		return "Category";
	}
	
	@PostMapping("/addCategory")
	public String saveSubject(@ModelAttribute("category") CATEGORY category)
	{
		categoryService.savecategory(category);
	return "redirect:/category";
	}
	//delete
		@RequestMapping(value="/deletecate",method= {RequestMethod.DELETE, RequestMethod.GET})
		public String deletecategory(int id) {
			categoryService.deletecategory(id);
			return "redirect:/category";
		}
@GetMapping("/updatecategory/{id}")
public String categ(@PathVariable (value="id") int id,Model model){
CATEGORY category = categoryService.getCategoryById(id);
  	model.addAttribute("category", category);
   	return "updatecategory";		    	 
   } 

@GetMapping ("/students")
public String getcateg(int id,Model model) {
	List<CATEGORY> cate=categoryService.getcategory();
	model.addAttribute("ourcategory", cate);
	
	Optional<STUDENTS> student= studRepo.findById(id);
	model.addAttribute("student",student.get());
	System.out.print(student);
	
	List<STUDENTRESULT> sture=categoryService.getstudentresult();
	model.addAttribute("sture", sture);
	return "StudentDashbord";
}
}



