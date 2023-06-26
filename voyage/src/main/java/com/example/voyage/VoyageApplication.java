package com.example.voyage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration 
@ComponentScan(basePackages= {"com.example.Controllers"})
@EntityScan("com.example.Entités")

public class VoyageApplication {

	public static void main(String[] args) {
		SpringApplication.run(VoyageApplication.class, args);
		
	}

}
