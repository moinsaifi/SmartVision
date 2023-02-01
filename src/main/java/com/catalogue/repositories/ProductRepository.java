package com.catalogue.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.catalogue.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
