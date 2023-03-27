package com.springboot.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.springboot.main", "company.*","user.*"})
public class GoodJobApplication {

	public static void main(String[] args) {
		SpringApplication.run(GoodJobApplication.class, args);
	}

}
