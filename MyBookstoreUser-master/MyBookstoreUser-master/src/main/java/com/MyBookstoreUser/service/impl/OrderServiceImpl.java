package com.MyBookstoreUser.service.impl;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MyBookstoreUser.model.BillingAddress;
import com.MyBookstoreUser.model.Book;
import com.MyBookstoreUser.model.CartItem;
import com.MyBookstoreUser.model.Order;
import com.MyBookstoreUser.model.Payment;
import com.MyBookstoreUser.model.ShippingAddress;
import com.MyBookstoreUser.model.ShoppingCart;
import com.MyBookstoreUser.model.User;
import com.MyBookstoreUser.repository.OrderRepository;
import com.MyBookstoreUser.service.CartItemService;
import com.MyBookstoreUser.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private CartItemService cartItemService;
	
	public synchronized Order createOrder(ShoppingCart shoppingCart,
											ShippingAddress shippingAddress,
											BillingAddress billingAddress,
											Payment payment,
											String shippingMethod,
											User user) 
	{
		Order order = new Order();
		order.setBillingAddress(billingAddress);
		order.setOrderStatus("ordered");
		order.setPayment(payment);
		order.setShippingAddress(shippingAddress);
		order.setShippingMethod(shippingMethod);
		
		List<CartItem> cartItemList = cartItemService.findByShoppingCart(shoppingCart);
		
		for(CartItem cartItem : cartItemList)
		{
			Book book = cartItem.getBook();
			cartItem.setOrder(order);
			book.setInStockNumber(book.getInStockNumber() - cartItem.getQty());
		}
		
		order.setCartItemList(cartItemList);
		order.setOrderDate(Calendar.getInstance().getTime());
		
		LocalDate today = LocalDate.now();
		LocalDate estimatedDeliveryDate;		
		if (shippingMethod.equals("groundShipping")) 
		{
			estimatedDeliveryDate = today.plusDays(5);
		} else
		{
			estimatedDeliveryDate = today.plusDays(3);
		}
		order.setShippingDate(estimatedDeliveryDate);
		
		order.setOrderTotal(shoppingCart.getGrandTotal());
		shippingAddress.setOrder(order);
		billingAddress.setOrder(order);
		payment.setOrder(order);
		order.setUser(user);
		order = orderRepository.save(order);
		
		return order;
	}
	
	public Optional<Order> findOne(Long id) 
	{
		return orderRepository.findById(id);
	}

}
