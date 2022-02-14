package com.apolis.sartapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

import com.apolis.entity.DBData;



@SpringBootApplication
@ComponentScan("com.apolis")
@PropertySource({"classpath:application-dev.properties","classpath:application-qa.properties"})
public class Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Application.class, args);
		DBData dbData  = (DBData)context.getBean("dbData");
		System.out.println(dbData);
	}

}
