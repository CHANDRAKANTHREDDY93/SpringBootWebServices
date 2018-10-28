package com.chand.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chand.demo.versioning.Name;
import com.chand.demo.versioning.PersonV1;
import com.chand.demo.versioning.PersonV2;

@RestController
public class VersioningController {
	
	//URI Versioning --> Used By Twitter
	@GetMapping(value="v1/version")
	public PersonV1 personV1() {
		return new PersonV1("Chandrakanth Verlapally");
	}
	@GetMapping(value="v2/version")
	public PersonV2 personV2() {
		return new PersonV2(new Name("Chandrakanth", "Verlapally"));
	}
	
	//Request parameter Versioning --> Used By Amazon
	@GetMapping(value="person/param", params="version=1")
	public PersonV1 paramV1() {
		return new PersonV1("Chandrakanth Verlapally");
	}
	@GetMapping(value="person/param", params="version=2")
	public PersonV2 paramV2() {
		return new PersonV2(new Name("Chandrakanth", "Verlapally"));
	}
	
	//Header Versioning --> Custom Header Versioning used by MicroSoft
	@GetMapping(value="person/header", headers="X-API_VERSION=1")
	public PersonV1 headerV1() {
		return new PersonV1("Chandrakanth Verlapally");
	}
	@GetMapping(value="person/header", headers="X-API_VERSION=2")
	public PersonV2 headerV2() {
		return new PersonV2(new Name("Chandrakanth", "Verlapally"));
	}
	
	//MIME TYPE Versioning or Media Type Versioning --> Used by Github
	@GetMapping(value="person/produces", produces="application/com.chand.version1+json")
	public PersonV1 producesV1() {
		return new PersonV1("Chandrakanth Verlapally");
	}
	@GetMapping(value="person/produces", produces="application/com.chand.version2+json")
	public PersonV2 producesV2() {
		return new PersonV2(new Name("Chandrakanth", "Verlapally"));
	}
}
