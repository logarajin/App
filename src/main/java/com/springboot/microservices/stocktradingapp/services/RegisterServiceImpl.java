package com.springboot.microservices.stocktradingapp.services;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.springboot.microservices.stocktradingapp.domain.User;


@Service
public class RegisterServiceImpl implements RegisterService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	static Map<String,User> userMap = new HashMap<>();
	

	@Override
	public User save(User user) {
		userMap.put(user.getUserId(), user);
		
		return user;
	}


	@Override
	public String getUser(User user) {
		
	       
		   if(userMap.containsKey(user.getUserId())){
				User checkuser = userMap.get(user.getUserId());
				
				
				if(!checkuser.getPassword().equals(user.getPassword())){
					 return "Invalid Password.Please enter correct password.";					
				}
		   }else{
			   return "Invalid user.Please register.";
		   }
		
		   
		   return "success";
	}


	
	
}