package com.MyBookstoreUser.repository;

import org.springframework.data.repository.CrudRepository;

import com.MyBookstoreUser.model.security.Role;

public interface RoleRepository extends CrudRepository<Role, Long> {
	Role findByname(String name);
}