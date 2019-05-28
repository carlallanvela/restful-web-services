package com.cvela.rest.basic.auth;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Spring Security configuration for Basic Authentication.
 * Note that this is not currently used as we're moving to JWT.
 * @author cvela
 *
 */
@Configuration
@EnableWebSecurity
public class SpringSecurityConfigurationBasicAuth extends WebSecurityConfigurerAdapter {

	/**
	 * Customized Spring Security Configuration
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.csrf().disable() // Disable Cross-site request forgery.
			.authorizeRequests()
			.antMatchers(HttpMethod.OPTIONS, "/**").permitAll() // Permit Options in request.
				.anyRequest().authenticated()
				.and()
			//.formLogin().and() Disable Web Login in Spring.
			.httpBasic(); // Use HTTP Basic Authentication
	}

}
