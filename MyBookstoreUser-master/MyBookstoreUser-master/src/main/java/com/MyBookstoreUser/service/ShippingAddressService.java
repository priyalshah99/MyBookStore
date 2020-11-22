package com.MyBookstoreUser.service;

import com.MyBookstoreUser.model.ShippingAddress;
import com.MyBookstoreUser.model.UserShipping;

public interface ShippingAddressService {
	ShippingAddress setByUserShipping(UserShipping userShipping, ShippingAddress shippingAddress);
}
		