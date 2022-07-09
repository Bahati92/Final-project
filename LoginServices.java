package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.USER;
import com.example.demo.repository.UserRepository;

@Service
public class LoginServices {
	@Autowired UserRepository userRepo;
	public List<USER> login(String username, String password ){
		return userRepo.findByUsernameAndPassword(username, password);
}


}

