package com.MyBookstoreAdmin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.MyBookstoreAdmin.model.Order;
import com.MyBookstoreAdmin.service.OrderService;

@Controller
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private OrderService orderService;

	@GetMapping("/orderList")
	public String orderList(Model model) 
	{
		List<Order> orderList = orderService.findAll();
		model.addAttribute("orderList", orderList);		
		return "orderList";
		
	}
}
