package com.nasa.nalog.api.model.response;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.nasa.nalog.domain.model.StatusDelivery;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeliveryResponseModel {
	private Long id;
	private DeliveryResumeCustomerResponseModel customer;
	private BigDecimal tax;
	private StatusDelivery status;
	private OffsetDateTime requestDate;
	
	@JsonInclude(value = Include.NON_NULL)
	private OffsetDateTime finishDate;
}
