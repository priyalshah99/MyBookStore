package com.MyBookstoreUser.repository;

import org.springframework.data.repository.CrudRepository;

import com.MyBookstoreUser.model.Order;

public interface OrderRepository extends CrudRepository<Order, Long>{

}
