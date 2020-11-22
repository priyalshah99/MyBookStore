package com.MyBookstoreAdmin.repository;

import org.springframework.data.repository.CrudRepository;

import com.MyBookstoreAdmin.model.security.Role;


public interface RoleRepository extends CrudRepository<Role, Long> {
	Role findByname(String name);
}
