package com.nasa.nalog.domain.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.groups.ConvertGroup;
import javax.validation.groups.Default;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.nasa.nalog.domain.ValidationGroup;
import com.nasa.nalog.domain.exception.MyResourceNotFoundException;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@JsonInclude(value = Include.NON_NULL)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Getter
@Setter
@Entity
public class Delivery {
	
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@Valid
	@ConvertGroup(from = Default.class, to = ValidationGroup.CustomerId.class)
	@NotNull
	private Customer customer;
	
	@Embedded
	private Receiver receiver;
	
	@NotNull
	private BigDecimal tax; 
	
	@Enumerated(EnumType.STRING)
	@JsonProperty(access = Access.READ_ONLY)
	private StatusDelivery status;
	
	@JsonProperty(access = Access.READ_ONLY)
	private OffsetDateTime requestDate;
	
	@JsonProperty(access = Access.READ_ONLY)
	private OffsetDateTime finishDate;

	public Delivery finish() {
		// TODO Auto-generated method stub
		isFinished();
		isCanceled();

		setStatus(StatusDelivery.FINISHED);
		setFinishDate(OffsetDateTime.now());
		
		return this;
	}
	
	public Delivery cancel() {
		isFinished();
		isCanceled();
		
		setStatus(StatusDelivery.CANCELED);
		setFinishDate(OffsetDateTime.now());
		
		return this;
	}
	
	public void isFinished() {
		if(getStatus().equals(StatusDelivery.FINISHED)) {
			throw new MyResourceNotFoundException("Delivery is finished");
		}
	}
	
	public void isCanceled() {
		if(getStatus().equals(StatusDelivery.CANCELED)) {
			throw new MyResourceNotFoundException("Delivery is canceled");
		};
	}

}
