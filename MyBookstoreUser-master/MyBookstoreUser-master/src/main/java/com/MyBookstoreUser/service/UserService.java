package com.MyBookstoreUser.service;

import java.util.Optional;
import java.util.Set;

import com.MyBookstoreUser.model.User;
import com.MyBookstoreUser.model.UserBilling;
import com.MyBookstoreUser.model.UserPayment;
import com.MyBookstoreUser.model.UserShipping;
import com.MyBookstoreUser.model.security.PasswordResetToken;
import com.MyBookstoreUser.model.security.UserRole;

public interface UserService {

	PasswordResetToken getPasswordResetToken(final String token);
	
	void createPasswordResetTokenForUser(final User user, final String token);
	
	User findByUsername(String username);
	
	User findByEmail (String email);
	
	Optional<User> findById(Long id);
	
	User createUser(User user, Set<UserRole> userRoles) throws Exception;
	
	User save(User user);

	void updateUserBilling(UserBilling userBilling, UserPayment userPayment, User user);
	
	void setUserDefaultPayment(Long userPaymentId, User user);
	
	void updateUserShipping(UserShipping userShipping, User user);
	
	void setUserDefaultShipping(Long userShippingId, User user);

}
