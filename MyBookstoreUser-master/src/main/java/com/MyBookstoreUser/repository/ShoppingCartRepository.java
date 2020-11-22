package com.MyBookstoreUser.repository;

import org.springframework.data.repository.CrudRepository;

import com.MyBookstoreUser.model.ShoppingCart;

public interface ShoppingCartRepository extends CrudRepository<ShoppingCart, Long> {

}
