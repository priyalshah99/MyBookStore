package com.MyBookstoreUser.service.impl;

import org.springframework.stereotype.Service;

import com.MyBookstoreUser.model.Payment;
import com.MyBookstoreUser.model.UserPayment;
import com.MyBookstoreUser.service.PaymentService;

@Service
public class PaymentServiceImpl implements PaymentService{
	
	public Payment setByUserPayment(UserPayment userPayment, Payment payment) {
		payment.setType(userPayment.getType());
		payment.setCardName(userPayment.getCardName());
		payment.setHolderName(userPayment.getHolderName());
		payment.setCardNumber(userPayment.getCardNumber());
		payment.setExpiryMonth(userPayment.getExpiryMonth());
		payment.setExpiryYear(userPayment.getExpiryYear());
		payment.setCvv(userPayment.getCvv());
		
		return payment;
	}

}
