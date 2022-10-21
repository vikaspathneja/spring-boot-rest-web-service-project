package com.example.springpropsdemo;

import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomExceptionWithCustomMessage extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllException(Exception ex, WebRequest request) throws Exception {
		UserErrorPojo uep=new UserErrorPojo(ex.getMessage());
		return new ResponseEntity<>(uep, null, HttpStatus.INTERNAL_SERVER_ERROR);

	}
	@ExceptionHandler(UserNotFoundException.class)
	public final ResponseEntity<Object> userNotFoundException(Exception ex, WebRequest request) throws Exception {
		UserErrorPojo uep=new UserErrorPojo(ex.getMessage());
		return new ResponseEntity<>(uep, null, HttpStatus.NOT_FOUND);

	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		StringBuilder sb=new StringBuilder();
		ex.getFieldErrors().stream().forEach(x->
		sb.append("----->"+x.getDefaultMessage()));
		UserErrorPojo uep=new UserErrorPojo(sb.toString());
		return new ResponseEntity<>(uep, null, HttpStatus.BAD_REQUEST);
	}
}
