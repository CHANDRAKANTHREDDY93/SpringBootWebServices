package com.chand.demo.controller;

import java.util.Arrays;
import java.util.List;


import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chand.demo.data.SomeBean;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilteringController {

	@GetMapping("/filtering")
	private MappingJacksonValue someBean() {
		SomeBean bean = new SomeBean("value1", "value2", "value3");
		SimpleBeanPropertyFilter someBeanProperty = SimpleBeanPropertyFilter.filterOutAllExcept("field1", "field2");
		FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", someBeanProperty);
		MappingJacksonValue mapping = new MappingJacksonValue(bean);
		mapping.setFilters(filters);
		
		return mapping;
	}
	
	@GetMapping("/filtering-list")
	private MappingJacksonValue returnSomeBean() {
		List<SomeBean> list = Arrays.asList(new SomeBean("value10", "value20", "value30"), new SomeBean("value11", "value22", "value33") );
		SimpleBeanPropertyFilter someBeanProperty = SimpleBeanPropertyFilter.filterOutAllExcept("field2", "field3");
		FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", someBeanProperty);
		MappingJacksonValue mapping = new MappingJacksonValue(list);
		mapping.setFilters(filters);
		
		return mapping;
	}
	
}
