package com.cvela.rest.basic.auth;

/**
 * Authentication Bean.
 * Note that this is not currently used as we're moving to JWT.
 * @author cvela
 *
 */
public class AuthenticationBean {
	private String message;
	public AuthenticationBean(String message) {
		this.message = message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}
	
	@Override
	public String toString() {
		return String.format("Authentication Bean [message=%s]", message);
	}
}
