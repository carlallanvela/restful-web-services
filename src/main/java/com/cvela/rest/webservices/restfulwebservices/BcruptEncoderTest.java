package com.cvela.rest.webservices.restfulwebservices;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Password Encoder Util.
 * @author Carl Allan Vela
 *
 */
public class BcruptEncoderTest {
	public static void main(String[] args) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		for (int i = 0; i <= 10; i++) {
			String encodedString = encoder.encode("password@!23$!");	
			System.out.println(encodedString);
		}	
	}
}
