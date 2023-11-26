package com.bd.producto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.bd")
public class LpiiCl3RicsechongsahirApplication {

	public static void main(String[] args) {
		SpringApplication.run(LpiiCl3RicsechongsahirApplication.class, args);
	}

}
