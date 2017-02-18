package com.ds4u.security;

import org.springframework.security.core.AuthenticationException;

public class JwtTokenMissingException extends AuthenticationException{

	public JwtTokenMissingException(String msg) {
		super(msg);
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -2066340191134455922L;

}
