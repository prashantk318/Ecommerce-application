package com.prashant.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prashant.entity.Product;

public interface ProductRepository extends JpaRepository<Product,Long> {

}
