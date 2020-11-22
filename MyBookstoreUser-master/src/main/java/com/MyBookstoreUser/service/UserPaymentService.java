package com.MyBookstoreUser.service;

import java.util.Optional;

import com.MyBookstoreUser.model.UserPayment;

public interface UserPaymentService {
	Optional<UserPayment> findById(Long id);
	
	void removeById(Long id);
}
