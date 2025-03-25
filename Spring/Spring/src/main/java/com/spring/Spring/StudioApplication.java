package com.spring.Spring;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RestController

public class StudioApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudioApplication.class, args);
	}

	@GetMapping("/mago")
		public String mago(@RequestParam(value = "name", defaultValue = "Grande Maaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaago") String name){
		return String.format("Olá %s!", name);
	}
}
