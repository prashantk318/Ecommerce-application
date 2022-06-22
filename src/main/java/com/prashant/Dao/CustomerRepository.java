package com.prashant.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prashant.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
