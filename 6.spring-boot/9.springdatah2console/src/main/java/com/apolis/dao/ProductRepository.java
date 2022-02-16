package com.apolis.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.apolis.entity.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

}
