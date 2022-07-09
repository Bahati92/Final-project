package com.example.demo.controller;


import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.model.CATEGORY;
import com.example.demo.model.STUDENTS;
import com.example.demo.model.SUBCATEGORY;
import com.example.demo.repository.StudentRepository;
import com.example.demo.services.SubcaregoryService;

@Controller
public class SubcategoryController {
	@Autowired
	SubcaregoryService subService;
	@Autowired StudentRepository studRepo;
	
	@GetMapping("/subCategory")
	public String getCategory(Model model) {
		
		List<CATEGORY> category=subService.getCategory();
		model.addAttribute("cat",category);
		
		List<SUBCATEGORY> subcategory=subService.getSubCategory();
		model.addAttribute("subcat",subcategory);
		return "subcategory";
	}
	
	@GetMapping("/ist1")
	public String getsubCategory(int id,Model model) {
		List<SUBCATEGORY> subcategory=subService.getSubCategory();
		model.addAttribute("subcat",subcategory);
		
		Optional<STUDENTS> student=studRepo.findById(id);
		model.addAttribute("student",student.get());
		System.out.print(student);
		
		return "subcategorylist";
	}
	@GetMapping("/v")	public String getsubCategoryv(Model model) {
	List<SUBCATEGORY> subcategory=subService.getSubCategory();
		model.addAttribute("subcat",subcategory);		
		return "video";
	}
	
	@PostMapping("/addsubCategory")
	public String create(String name,int category_id,@RequestParam("videoFile") MultipartFile videoFile) throws IOException {
		subService.create(name,category_id,videoFile);
		return "redirect:/subCategory";
	}
	
//	@GetMapping("/getById")
//	public Optional<SUBCATEGORY> getByid(int id,Model model){
//		return subService.getById(id);
		
//		Optional<SUBCATEGORY> subCategory=subService.getById(id);
//		model.addAttribute("subCategory", subCategory);
//		return "redirect:/ist1";
//	}
	//delete
		@RequestMapping(value="/deletesubcategory",method= {RequestMethod.DELETE, RequestMethod.GET})
				public String deletesubcategory(int id) {
			subService.deleteSubcategory(id);
					return "redirect:/subCategory";
				}
		@GetMapping("/updatesubcategory/{id}")
		public String categ(@RequestParam("id") int id,Model model){
		SUBCATEGORY subcategory =  subService.getSubcategoryById(id);
		  	model.addAttribute("subcategory", subcategory);
		   	return "updatesubcategory";		    	 
		   } 

@GetMapping("/viewVideoByid/{id}")
	public String viwsub(@PathVariable("id") int id,Model model){
	SUBCATEGORY subcategory =  subService.getSubcategoryById(id);
  	model.addAttribute("subcategor", subcategory);
   	return "video";		    	 
   } 


}
