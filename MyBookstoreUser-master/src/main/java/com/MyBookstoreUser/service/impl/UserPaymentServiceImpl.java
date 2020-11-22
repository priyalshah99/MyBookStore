package com.MyBookstoreUser.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MyBookstoreUser.model.UserPayment;
import com.MyBookstoreUser.repository.UserPaymentRepository;
import com.MyBookstoreUser.service.UserPaymentService;

@Service
public class UserPaymentServiceImpl implements UserPaymentService{

	@Autowired
	private UserPaymentRepository userPaymentRepository;
		
	public Optional<UserPayment> findById(Long id) {
		return userPaymentRepository.findById(id);
	}
	
	public void removeById(Long id) {
		userPaymentRepository.deleteById(id);
	}
} 
