package com.cvela.rest.basic.auth;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * This controller handles the basic authentication.
 * Note that this is not currently used as we're moving to JWT.
 * @author cvela
 *
 */
@CrossOrigin("http://localhost:4200") //Allow requests from other domains
@RestController
public class BasicAuthenticationController {
	
	@GetMapping(path = "/basicauth")
	public AuthenticationBean authenticationBean() {
		return new AuthenticationBean("You are authenticated.");
	}
}
