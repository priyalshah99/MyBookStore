package com.MyBookstoreUser.controller;

import java.security.Principal;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.MyBookstoreUser.model.CartItem;
import com.MyBookstoreUser.model.Order;
import com.MyBookstoreUser.model.User;
import com.MyBookstoreUser.model.UserShipping;
import com.MyBookstoreUser.service.CartItemService;
import com.MyBookstoreUser.service.OrderService;
import com.MyBookstoreUser.service.UserService;
import com.MyBookstoreUser.service.impl.UserSecurityService;
import com.MyBookstoreUser.utility.INConstants;
import com.MyBookstoreUser.utility.SecurityUtility;

@Controller
public class ProfileController {

	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserSecurityService userSecurityService;
	
	@Autowired
	private CartItemService cartItemService;
	
	@Autowired
	private OrderService orderService;
	
	
	@RequestMapping("/myProfile")
	public String myProfile(Model model, Principal principal) 
	{
		User user = userService.findByUsername(principal.getName());
		
		model.addAttribute("user", user);
		model.addAttribute("userPaymentList", user.getUserPaymentList());
		model.addAttribute("userShippingList", user.getUserShippingList());
		model.addAttribute("orderList", user.getOrderList());
		
		UserShipping userShipping = new UserShipping();
		model.addAttribute("userShipping", userShipping);
		
		model.addAttribute("listOfCreditCards", true);
		model.addAttribute("listOfShippingAddresses", true);
		
		List<String> stateList = INConstants.listOfINStatesCode;
		Collections.sort(stateList);
		model.addAttribute("stateList", stateList);
		model.addAttribute("classActiveEdit", true);
		
		return "myProfile";
	}
	
	
	
	@PostMapping(value="/updateUserInfo")
	public String updateUserInfo(@ModelAttribute("user") User user,
			 @ModelAttribute("newPassword") String newPassword,
			 Model model) throws Exception
	{
		User currentUser = userService.findById(user.getId()).orElse(null);
		
		if(currentUser == null) {
		throw new Exception ("User not found");
		}
		
		//update password
		if (newPassword != null && !newPassword.isEmpty() && !newPassword.equals(""))
		{
			BCryptPasswordEncoder passwordEncoder = SecurityUtility.passwordEncoder();
			String dbPassword = currentUser.getPassword();
			
			if(passwordEncoder.matches(user.getPassword(), dbPassword))
			{
				currentUser.setPassword(passwordEncoder.encode(newPassword));
			}
			else
			{
				model.addAttribute("incorrectPassword", true);
				return "myProfile";
			}
		}
		
		currentUser.setFirstName(user.getFirstName());
		currentUser.setLastName(user.getLastName());
		currentUser.setPhone(user.getPhone());
		
		userService.save(currentUser);
		
		model.addAttribute("updateSuccess", true);
		model.addAttribute("user", currentUser);
		model.addAttribute("classActiveEdit", true);
		
		model.addAttribute("listOfShippingAddresses", true);
		model.addAttribute("listOfCreditCards", true);
		
		UserDetails userDetails = userSecurityService.loadUserByUsername(currentUser.getUsername());
		
		Authentication authentication = new UsernamePasswordAuthenticationToken(userDetails, userDetails.getPassword(),
		userDetails.getAuthorities());
		
		SecurityContextHolder.getContext().setAuthentication(authentication);
		model.addAttribute("orderList", user.getOrderList());
		
		return "redirect:/myProfile";
	}


	@RequestMapping("/orderDetail")
	public String orderDetail(@RequestParam("id") Long orderId,
								Principal principal, Model model)
	{
		User user = userService.findByUsername(principal.getName());
		Order order = orderService.findOne(orderId).orElse(null);
		
		if(order.getUser().getId()!=user.getId()) 
		{
			return "error";
		} 
		else
		{
			List<CartItem> cartItemList = cartItemService.findByOrder(order);
			model.addAttribute("cartItemList", cartItemList);
			model.addAttribute("user", user);
			model.addAttribute("order", order);
			
			model.addAttribute("userPaymentList", user.getUserPaymentList());
			model.addAttribute("userShippingList", user.getUserShippingList());
			model.addAttribute("orderList", user.getOrderList());
			
			UserShipping userShipping = new UserShipping();
			model.addAttribute("userShipping", userShipping);
			
			List<String> stateList = INConstants.listOfINStatesName;
			Collections.sort(stateList);
			model.addAttribute("stateList", stateList);
			
			model.addAttribute("listOfShippingAddresses", true);
			model.addAttribute("classActiveOrders", true);
			model.addAttribute("listOfCreditCards", true);
			model.addAttribute("displayOrderDetail", true);
			
			return "myProfile";
		}
	}

}
