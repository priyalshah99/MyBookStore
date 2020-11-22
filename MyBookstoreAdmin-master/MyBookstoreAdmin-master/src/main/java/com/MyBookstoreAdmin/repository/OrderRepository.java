package com.MyBookstoreAdmin.repository;

import org.springframework.data.repository.CrudRepository;

import com.MyBookstoreAdmin.model.Order;

public interface OrderRepository extends CrudRepository<Order, Long>{

}
