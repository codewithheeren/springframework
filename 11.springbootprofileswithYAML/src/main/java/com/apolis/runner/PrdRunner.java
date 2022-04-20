package com.apolis.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

//@Component
@Profile("prod")
public class PrdRunner implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		System.out.println("production properties will initilized here");

	}

}
