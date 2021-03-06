package com.cvela.rest.webservices.restfulwebservices.helloworld;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Hello World Controller.
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
		try {
			return new HelloWorldBean("Hello World");
		} catch (Exception e) {
			throw new RuntimeException("Some error has Happened!"
					+ " Please contact support.");	
		}
	}
	
	// hello-world with path parameter
	@GetMapping(path = "/hello-world/path-variable/{name}")
	public HelloWorldBean helloWorldPathVariable(@PathVariable String name) {
		//replace % with name
		return new HelloWorldBean(String.format("Hello World, %s!", name));
	}
}
