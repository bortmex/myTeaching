package com.rog.teach.aop.repository;

import com.rog.teach.aop.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer>{

}