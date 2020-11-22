package com.MyBookstoreUser.service;

import com.MyBookstoreUser.model.BillingAddress;
import com.MyBookstoreUser.model.UserBilling;

public interface BillingAddressService {
	BillingAddress setByUserBilling(UserBilling userBilling, BillingAddress billingAddress);
}
