package com.cvela.rest.webservices.restfulwebservices;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * This Controller handles REST Requests.
 * @author cvela
 *
 */
@CrossOrigin("http://localhost:4200") //Allow requests from other domains
@RestController
public class HelloWorldController {
	
	// GET - HTTP Request
	// URI - /hello-world
	// Can use either request mapping or GetMapping
	// @RequestMapping(method=RequestMethod.GET, path="/hello-world")
	@GetMapping(path = "/hello-world")
	public String helloWorld() {
		return "Hello World";
	}
	
	// hello-world-bean
	@GetMapping(path = "/hello-world-bean")
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("Hello World");
	}
	
	// hello-world with path parameter
	// hello-world/path-variable/name
	@GetMapping(path = "/hello-world/path-variable/{name}")
	public HelloWorldBean helloWorldPathVariable(@PathVariable String name) {
		return new HelloWorldBean(String.format("Hello World %s", name)); //replace % with name
	}
}
