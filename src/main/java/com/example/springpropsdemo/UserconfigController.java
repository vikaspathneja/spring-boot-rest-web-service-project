package com.example.springpropsdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserconfigController {

	@Autowired
	UserPropsConfiguration config;


	@GetMapping("/userprops")
	public UserPropsConfiguration getUserConfig() {
		return config;
	}
}
