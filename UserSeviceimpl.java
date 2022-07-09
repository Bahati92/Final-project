package com.example.demo.services;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.CATEGORY;
import com.example.demo.model.USER;
import com.example.demo.repository.UserRepository;

@Service
public class UserSeviceimpl  implements UserService {
	@Autowired UserRepository userRepo;

	@Override
	public void saveUser(USER user) {
		this.userRepo.save(user);	
	}

	@Override
	public List<USER> getAllUser() {
		// TODO Auto-generated method stub
		return userRepo.findAll();
	}

	@Override
	public void deleteuser(int id) {
		userRepo.deleteById(id);
		
	}

	@Override
	public USER getuserById(int id) {
		Optional<USER> optional =userRepo.findById(id);
		USER user= null;
		if(optional.isPresent()) {
			user=optional.get();
		}else {
		throw new RuntimeException("type ofnot found for id : :"+id);
	}
		return user;
	}

	@Override
	public Optional<USER> getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<USER> getById1(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
		
	
	
	
}
