package com.nasa.nalog.domain.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nasa.nalog.domain.model.Delivery;
import com.nasa.nalog.domain.repository.DeliveryRepository;


import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class FindAllDeliveryService {

	private DeliveryRepository deliveryRepository;
	
	@Transactional
	public List<Delivery> execute() {
		return deliveryRepository.findAll();
	}
}
