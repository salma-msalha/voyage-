package com.example.voyage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example.Controller"})
public class VoyageApplication {

	public static void main(String[] args) {
		SpringApplication.run(VoyageApplication.class, args);
		
	}

}
