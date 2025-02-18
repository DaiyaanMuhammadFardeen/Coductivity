package com.coductivity.Coductivity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.coductivity")
public class CoductivityApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoductivityApplication.class, args);
	}

}
