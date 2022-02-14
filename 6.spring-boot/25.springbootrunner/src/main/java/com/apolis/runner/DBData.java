package com.apolis.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
@Component
class DBInit implements CommandLineRunner{

	@Override
	public void run(String... args) throws Exception {
		System.out.println("db data inserted.");
	}
	
	
}