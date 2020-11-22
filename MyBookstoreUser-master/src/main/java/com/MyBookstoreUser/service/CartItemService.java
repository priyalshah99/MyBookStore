package com.MyBookstoreUser.service;

import java.util.List;
import java.util.Optional;

import com.MyBookstoreUser.model.Book;
import com.MyBookstoreUser.model.CartItem;
import com.MyBookstoreUser.model.Order;
import com.MyBookstoreUser.model.ShoppingCart;
import com.MyBookstoreUser.model.User;

public interface CartItemService 
{
	List<CartItem> findByShoppingCart(ShoppingCart shoppingCart);
	
	CartItem updateCartItem(CartItem cartItem);
	
	CartItem addBookToCartItem(Book book, User user, int qty);
	
	Optional<CartItem> findById(Long id);
	
	void removeCartItem(CartItem cartItem);
	
	CartItem save(CartItem cartItem);
	
	List<CartItem> findByOrder(Order order);
}
