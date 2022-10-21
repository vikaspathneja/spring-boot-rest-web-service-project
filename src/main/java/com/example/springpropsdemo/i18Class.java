package com.example.springpropsdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

@RestController
public class i18Class {

	@Autowired
	MessageSource ms;

	@GetMapping("hello-world")
	public String getHelloWorld() {
		return ms.getMessage("hello-world", null, "hello world default message", LocaleContextHolder.getLocale());
	}

	@GetMapping(path = "personwithparam", params = "version=1")
	public String getHelloWorldV1() {
		return "person with request param V1";
	}
	@GetMapping(path = "personwithparam", params = "version=2")
	public String getHelloWorldV2() {
		return "person with request param V2";
	}
	@GetMapping(path = "personwithheader", headers ="X-API-VERSION=1")
	public String getHelloWorldV3() {
		return "person with request header V1";
	}
	@GetMapping(path = "personwithheader", headers = "X-API-VERSION=2")
	public String getHelloWorldV4() {
		return "person with request header V2";
	}
	@GetMapping(path = "personwithacceptheader", produces = "application/text")
	public String getHelloWorldV5() {
		return "person with request header accept";
	}
	
}
