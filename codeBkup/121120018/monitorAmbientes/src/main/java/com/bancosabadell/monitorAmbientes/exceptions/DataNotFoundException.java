package com.bancosabadell.monitorAmbientes.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class DataNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1229250843396302587L;

	public DataNotFoundException(String message) {
		super(message);
	}
}
