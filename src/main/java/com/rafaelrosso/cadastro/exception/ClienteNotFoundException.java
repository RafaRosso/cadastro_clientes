package com.rafaelrosso.cadastro.exception;

import javax.persistence.EntityNotFoundException;

public class ClienteNotFoundException extends EntityNotFoundException {

	public ClienteNotFoundException(String message) {
		super(message);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
