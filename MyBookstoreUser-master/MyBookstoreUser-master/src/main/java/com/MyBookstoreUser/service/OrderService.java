package com.MyBookstoreUser.service;

import java.util.Optional;

import com.MyBookstoreUser.model.BillingAddress;
import com.MyBookstoreUser.model.Order;
import com.MyBookstoreUser.model.Payment;
import com.MyBookstoreUser.model.ShippingAddress;
import com.MyBookstoreUser.model.ShoppingCart;
import com.MyBookstoreUser.model.User;

public interface OrderService {
	Order createOrder(ShoppingCart shoppingCart,ShippingAddress shippingAddress,
						BillingAddress billingAddress,Payment payment,
						String shippingMethod,User user);
	
	Optional<Order> findOne(Long id);
}
