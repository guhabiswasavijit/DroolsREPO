package org.seven.telecom.domain;

import java.io.Serializable;

public class AuthenticationSuccessResponse implements Serializable {
	private static final long serialVersionUID = 1L;
	private final String message;

	public AuthenticationSuccessResponse(String message) {
		this.message = message;
	}

	public String getMessage() {
		return this.message;
	}
}
