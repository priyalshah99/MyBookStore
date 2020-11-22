package com.MyBookstoreAdmin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/")
	public String index(){
		return "redirect:/book/bookList";
	}
	
	@GetMapping("/login")
	public String login(){
		return "login";
	}
}
