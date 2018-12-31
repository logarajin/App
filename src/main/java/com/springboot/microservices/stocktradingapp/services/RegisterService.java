package com.springboot.microservices.stocktradingapp.services;

import com.springboot.microservices.stocktradingapp.domain.User;

public interface RegisterService {


	String getUser(User user);

	User save(User user);


}
