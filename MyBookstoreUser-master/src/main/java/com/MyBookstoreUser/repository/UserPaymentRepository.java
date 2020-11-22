package com.MyBookstoreUser.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.MyBookstoreUser.model.UserPayment;

public interface UserPaymentRepository extends JpaRepository<UserPayment, Long>{

}
