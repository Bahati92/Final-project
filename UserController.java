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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.model.CATEGORY;
import com.example.demo.model.SUBJECT;
import com.example.demo.model.USER;
import com.example.demo.services.UserService;


@Controller
public class UserController {
	
	@Autowired
	private  UserService userServices ;

	@GetMapping ("/USER")
	public String getUsers(Model model, String USER) {
	
	return USER;
	}
	@GetMapping ("/login")
	public String login(Model model) {
		return "login";
	}
	
	
	@GetMapping ("/usersaddNew")
	public String addNew(USER user) {
		userServices.saveUser(user);
		return "redirect:/sa";
	}
		
		@GetMapping ("/sa")
		public String users(Model model) {
			List<USER>user= userServices.getAllUser();
			model.addAttribute("user",user);
			return "Registration";
		}
		@GetMapping("/getById{id}")
		public Optional<USER> getByid(int id,Model model){
			return userServices.getById(id);
		}
		
		
		//delete
				@RequestMapping(value="/deleteuser",method= {RequestMethod.DELETE, RequestMethod.GET})
				public String deleteuser(int id) {
					userServices.deleteuser(id);
					return "redirect:/sa";
				}

@GetMapping("/updateuser/{id}")
public String users(@PathVariable (value="id") int id,Model model){
 USER user= userServices.getuserById(id);
  	model.addAttribute("user", user);
   	return "updateuser";		    	 
   }

//	@PostMapping("/saveUser")
//	public String saveUser(@ModelAttribute("user") USER user)
//	{
//	userServices.saveUser(user);
//	return "redirect:/login";
//	}
}





