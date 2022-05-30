package com.nasa.nalog.api.exceptionHanlder;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@JsonInclude(value = Include.NON_NULL)
@Setter
@Getter
public class ApiError {
	private Integer status;
	private String title;
	private LocalDateTime date; 
	private List<Field> fields;
	
	
	@AllArgsConstructor
	@Getter
	public static class Field {
		 private String name;
		 private String message;
	};
}
