package com.apolis.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
class FileReader implements CommandLineRunner{

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Start reading data from file");
	}
}