package com.nasa.nalog.domain.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class Receiver {
	
	@NotBlank
	@Column(name = "receiver_name")
	private String name;
	
	@NotBlank
	@Column(name = "receiver_address")
	private String address;
	
	@NotBlank 
	@Column(name = "receiver_number")
	private String number;
	
	@Column(name = "receiver_address2")
	private String address2;
	
	@NotBlank
	@Column(name = "receiver_district")
	private String district;
}
