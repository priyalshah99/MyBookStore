package com.MyBookstoreUser.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.MyBookstoreUser.model.BookToCartItem;
import com.MyBookstoreUser.model.CartItem;

@Transactional
public interface BookToCartItemRepository extends CrudRepository<BookToCartItem, Long> {
	
	void deleteByCartItem(CartItem cartItem);
	
}
