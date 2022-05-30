package com.nasa.nalog.api.exceptionHanlder;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.nasa.nalog.domain.exception.MyResourceBadRequestException;
import com.nasa.nalog.domain.exception.MyResourceNotFoundException;

@ControllerAdvice
public class ApiExceptionHandle extends ResponseEntityExceptionHandler {
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		List<ApiError.Field> fields = new ArrayList<>();
		
		for(ObjectError error: ex.getBindingResult().getAllErrors()) {
			String name = ((FieldError) error).getField();
			String message = error.getDefaultMessage();
			
			fields.add(new ApiError.Field(name, message));
		}
		
		ApiError apiError = new ApiError();
		
		apiError.setStatus(status.value());
		apiError.setTitle("Algum campo preenchido de forma incorreto");
		apiError.setDate(LocalDateTime.now());
		apiError.setFields(fields);
		
		return handleExceptionInternal(ex, apiError, headers, status, request);
	}
	
	@ExceptionHandler(MyResourceNotFoundException.class)
	public ResponseEntity<Object> handleMyResourceNotFound(
			MyResourceNotFoundException ex, 
			WebRequest request
	){
		HttpStatus status = HttpStatus.NOT_FOUND;
		
		ApiError apiError = new ApiError();
		
		apiError.setStatus(status.value());
		apiError.setTitle(ex.getMessage());
		apiError.setDate(LocalDateTime.now());
		
		return handleExceptionInternal(ex, apiError, new HttpHeaders(), status, request);
	}
	
	@ExceptionHandler(MyResourceBadRequestException.class)
	public ResponseEntity<Object> handleMyResourceBadRequest(
			MyResourceBadRequestException ex, 
			WebRequest request
	){
		HttpStatus status = HttpStatus.BAD_REQUEST;
		
		ApiError apiError = new ApiError();
		
		apiError.setStatus(status.value());
		apiError.setTitle(ex.getMessage());
		apiError.setDate(LocalDateTime.now());
		
		return handleExceptionInternal(ex, apiError, new HttpHeaders(), status, request);
	}	
}
