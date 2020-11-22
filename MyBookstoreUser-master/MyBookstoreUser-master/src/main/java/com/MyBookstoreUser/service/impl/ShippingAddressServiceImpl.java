package com.MyBookstoreUser.service.impl;

import org.springframework.stereotype.Service;

import com.MyBookstoreUser.model.ShippingAddress;
import com.MyBookstoreUser.model.UserShipping;
import com.MyBookstoreUser.service.ShippingAddressService;

@Service
public class ShippingAddressServiceImpl implements ShippingAddressService 
{
	public ShippingAddress setByUserShipping(UserShipping userShipping, ShippingAddress shippingAddress) 
	{
		shippingAddress.setShippingAddressName(userShipping.getUserShippingName());
		shippingAddress.setShippingAddressStreet1(userShipping.getUserShippingStreet1());
		shippingAddress.setShippingAddressStreet2(userShipping.getUserShippingStreet2());
		shippingAddress.setShippingAddressCity(userShipping.getUserShippingCity());
		shippingAddress.setShippingAddressState(userShipping.getUserShippingState());
		shippingAddress.setShippingAddressCountry(userShipping.getUserShippingCountry());
		shippingAddress.setShippingAddressZipcode(userShipping.getUserShippingZipcode());
		
		return shippingAddress;
	}
}
