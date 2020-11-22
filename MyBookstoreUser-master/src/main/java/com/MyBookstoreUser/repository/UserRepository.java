package com.MyBookstoreUser.repository;

import org.springframework.data.repository.CrudRepository;

import com.MyBookstoreUser.model.User;

public interface UserRepository extends CrudRepository<User, Long> {
	User findByUsername(String username);
	
	User findByEmail(String email);
}
