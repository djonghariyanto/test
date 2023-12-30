package com.example.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Test {

    @GetMapping("doh")
	public String Doh() {
		return "babon recent push this is doh";
	}
    
    @GetMapping("greeter")
	public Greeting Greeter() {

	return new Greeting(1, String.format("%s", "s dumb dumb babon gila"));
	}

	public static void main(String[] args) {
		SpringApplication.run(Test.class, args);
	}
}
