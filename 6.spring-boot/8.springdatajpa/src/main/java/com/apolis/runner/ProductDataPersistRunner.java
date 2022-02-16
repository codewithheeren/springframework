package com.apolis.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.apolis.dao.ProductRepository;
import com.apolis.entity.Product;

@Component
public class ProductDataPersistRunner implements CommandLineRunner {

	@Autowired
	ProductRepository repository;
	
	@Override
	public void run(String... args) throws Exception {
		repository.save(new Product("Laptop", 5000));
		repository.save(new Product("mobile", 4000));
		repository.save(new Product("power bank", 1000));
	}

}
