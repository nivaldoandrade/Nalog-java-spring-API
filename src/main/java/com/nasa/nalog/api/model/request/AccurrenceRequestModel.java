package com.nasa.nalog.api.model.request;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccurrenceRequestModel {
	@NotBlank
	private String describe;
}
