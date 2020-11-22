package com.MyBookstoreAdmin.repository;

import org.springframework.data.repository.CrudRepository;

import com.MyBookstoreAdmin.model.User;

public interface UserRepository extends CrudRepository<User, Long> {
	User findByUsername(String username);
}
