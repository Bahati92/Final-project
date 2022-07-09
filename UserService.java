package com.example.demo.services;


import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;


import com.example.demo.model.USER;
@Service
public interface UserService
{
	
	void saveUser(USER user);
	List<USER> getAllUser();
	void deleteuser(int id);
	USER getuserById(int id);
	Optional<USER> getById(int id);
	Optional<USER> getById1(int id);
	
	


}
