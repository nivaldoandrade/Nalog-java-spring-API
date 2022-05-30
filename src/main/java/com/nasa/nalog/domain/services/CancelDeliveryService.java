package com.nasa.nalog.domain.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nasa.nalog.domain.exception.MyResourceNotFoundException;
import com.nasa.nalog.domain.model.Delivery;
import com.nasa.nalog.domain.repository.DeliveryRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CancelDeliveryService {
	
	private DeliveryRepository deliveryRepository;
	
	@Transactional
	public void execute(Long deliveryId) {
		Delivery delivery = deliveryRepository.findById(deliveryId)
				.orElseThrow(() -> new MyResourceNotFoundException("Delivery not found."));
		
		delivery.cancel();
		
		deliveryRepository.save(delivery);
	}
}
