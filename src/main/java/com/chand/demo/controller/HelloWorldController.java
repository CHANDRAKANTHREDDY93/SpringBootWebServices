package com.chand.demo.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	
	@RequestMapping(value="/hello-world", method=RequestMethod.GET)
	public String test() {
		return "Hello world";
	}
	
	@RequestMapping(value="/hello-world-bean/{name}", method=RequestMethod.GET)
	public HelloWorldBean testBean(@PathVariable String name) {
		return new HelloWorldBean(String.format("Hello World from, %s", name));
	}
}
