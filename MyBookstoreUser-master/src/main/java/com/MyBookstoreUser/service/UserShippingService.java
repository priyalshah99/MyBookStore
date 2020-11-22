package com.MyBookstoreUser.service;

import java.util.Optional;

import com.MyBookstoreUser.model.UserShipping;

public interface UserShippingService {
	Optional<UserShipping> findById(Long id);
	
	void removeById(Long id);
}
