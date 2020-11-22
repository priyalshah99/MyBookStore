package com.MyBookstoreAdmin.service;

import java.util.Set;

import com.MyBookstoreAdmin.model.User;
import com.MyBookstoreAdmin.model.security.UserRole;



public interface UserService {
	User createUser(User user, Set<UserRole> userRoles) throws Exception;
	
	User save(User user);
}
