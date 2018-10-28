package com.chand.demo.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	
	@Autowired
	private MessageSource messageSource;
	
	@RequestMapping(value="/hello-world", method=RequestMethod.GET)
	public String test() {
		return "Hello world";
	}
	@RequestMapping(value="/hello-world/internationalized", method=RequestMethod.GET)
	public String getMessage(@RequestHeader(
		name="Accept-Language", required=false) Locale locale) {
		System.out.println("System out print" +locale);
		return messageSource.getMessage("good.morning.message", null, LocaleContextHolder.getLocale());
	}
	
	@RequestMapping(value="/hello-world-bean/{name}", method=RequestMethod.GET)
	public HelloWorldBean testBean(@PathVariable String name) {
		return new HelloWorldBean(String.format("Hello World from, %s", name));
	}
}
