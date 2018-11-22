package com.bancosabadell.monitorAmbientes.exceptions;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * Clase dese&ntilde;ada para manejar todas las peticiones REST.
 * 
 * @author Jesus Alfredo Hernandez Orozco.
 *
 */
@RestController
@ControllerAdvice
public class MonitorExceptionHandler extends ResponseEntityExceptionHandler {

	public MonitorExceptionHandler() {
		// TODO Auto-generated constructor stub
	}
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> manejarTodasLasExcepciones(Exception ex, WebRequest request) {
		ExceptionResponse exceptionResponse =new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));	
		return new ResponseEntity(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(DataNotFoundException.class)
	public final ResponseEntity<Object> manejarUsuarioNoEncontradoExcepcion(DataNotFoundException ex, WebRequest request) {
		ExceptionResponse exceptionResponse =new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));	
		return new ResponseEntity(exceptionResponse, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(BadRequestException.class)
	public final ResponseEntity<Object> manejarValidacionExcepcion(BadRequestException ex, WebRequest request) {
		ExceptionResponse exceptionResponse =new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));	
		return new ResponseEntity(exceptionResponse, HttpStatus.BAD_REQUEST);
	}
}
