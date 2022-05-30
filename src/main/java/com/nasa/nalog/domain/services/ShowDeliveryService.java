package com.nasa.nalog.domain.services;

import org.springframework.stereotype.Service;

import com.nasa.nalog.domain.exception.MyResourceNotFoundException;
import com.nasa.nalog.domain.model.Delivery;
import com.nasa.nalog.domain.repository.DeliveryRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ShowDeliveryService {

	private DeliveryRepository deliveryRepository;
	
	public Delivery execute(Long deliveryId) {
		return deliveryRepository.findById(deliveryId)
				.orElseThrow(() -> new MyResourceNotFoundException("Delivery not found."));
	}
}
