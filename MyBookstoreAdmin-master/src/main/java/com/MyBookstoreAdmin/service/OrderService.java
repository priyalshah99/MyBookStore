package com.MyBookstoreAdmin.service;

import java.util.List;

import com.MyBookstoreAdmin.model.Order;

public interface OrderService {
	
	List<Order> findAll();
	
}
