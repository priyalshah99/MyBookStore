package com.MyBookstoreAdmin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MyBookstoreAdmin.model.Order;
import com.MyBookstoreAdmin.repository.OrderRepository;
import com.MyBookstoreAdmin.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	private OrderRepository orderRepository;

	public List<Order> findAll() {
		return (List<Order>) orderRepository.findAll();
	}
}
