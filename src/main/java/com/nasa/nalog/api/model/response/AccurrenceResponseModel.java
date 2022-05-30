package com.nasa.nalog.api.model.response;

import java.time.OffsetDateTime;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AccurrenceResponseModel {
	
	private Long id;
	private String describe;
	private DeliveryResponseModel delivery;
	private OffsetDateTime registerDate;
	
}
