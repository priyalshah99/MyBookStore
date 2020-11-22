package com.MyBookstoreUser.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.MyBookstoreUser.model.Book;
import com.MyBookstoreUser.model.CartItem;
import com.MyBookstoreUser.model.ShoppingCart;
import com.MyBookstoreUser.model.User;
import com.MyBookstoreUser.service.BookService;
import com.MyBookstoreUser.service.CartItemService;
import com.MyBookstoreUser.service.ShoppingCartService;
import com.MyBookstoreUser.service.UserService;

@Controller
@RequestMapping("/shoppingCart")
public class ShoppingCartController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private CartItemService cartItemService;

	@Autowired
	private ShoppingCartService shoppingCartService;
	
	@Autowired
	private BookService bookService;
	
	
	@RequestMapping("/cart")
	public String shoppingCart(Model model, Principal principal) {
		User user = userService.findByUsername(principal.getName());
		ShoppingCart shoppingCart = user.getShoppingCart();
		
		List<CartItem> cartItemList = cartItemService.findByShoppingCart(shoppingCart);
		
		shoppingCartService.updateShoppingCart(shoppingCart);
		
		model.addAttribute("cartItemList", cartItemList);
		model.addAttribute("shoppingCart", shoppingCart);
		
		return "shoppingCart";
	}

	@RequestMapping("/addItem")
	public String addItem(@ModelAttribute("book") Book book,
						  @ModelAttribute("qty") String qty,
						  Model model, Principal principal)
	{
		User user = userService.findByUsername(principal.getName());
		book = bookService.findOne(book.getId()).get();
		
		if (Integer.parseInt(qty) > book.getInStockNumber()) 
		{
			model.addAttribute("notEnoughStock", true);
			return "forward:/bookDetail?id="+book.getId();
		}
		
		CartItem cartItem = cartItemService.addBookToCartItem(book, user, Integer.parseInt(qty));
		model.addAttribute("addBookSuccess", true);
		
		return "forward:/bookDetail?id="+book.getId();
	}
	
	@RequestMapping("/updateCartItem")
	public String updateShoppingCart(@ModelAttribute("id") Long cartItemId,
									 @ModelAttribute("qty") int qty,Model model)
	{
		CartItem cartItem = cartItemService.findById(cartItemId).get();
		if(qty>0) {
			cartItem.setQty(qty);
			cartItemService.updateCartItem(cartItem);
		}
		else {
			return "forward:/shoppingCart/removeItem";
		}
		
		return "forward:/shoppingCart/cart";
	}
	
	@RequestMapping("/removeItem")
	public String removeItem(@RequestParam("id") Long id) 
	{
		cartItemService.removeCartItem(cartItemService.findById(id).get());
		
		return "forward:/shoppingCart/cart";
	}
}
