package com.apolis.startapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.apolis.dao.ProductRepository;
import com.apolis.entity.Product;

@SpringBootApplication
@ComponentScan("com.apolis")
@EnableJpaRepositories("com.apolis.dao")
@EntityScan("com.apolis.entity")
public class Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Application.class, args);
		ProductRepository repository = (ProductRepository) context.getBean("productRepository");
		repository.save(new Product("Laptop", 21000));
	}

}