package com.MyBookstoreUser.service;

import com.MyBookstoreUser.model.Payment;
import com.MyBookstoreUser.model.UserPayment;

public interface PaymentService {
	Payment setByUserPayment(UserPayment userPayment, Payment payment);
}
