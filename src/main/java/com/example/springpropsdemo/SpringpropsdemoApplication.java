package com.example.springpropsdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication(scanBasePackages = "com.example.springpropsdemo")
@RestController
public class SpringpropsdemoApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(SpringpropsdemoApplication.class, args);
	}

}
