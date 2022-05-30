package com.nasa.nalog.domain.services;

import java.time.OffsetDateTime;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nasa.nalog.domain.model.Delivery;
import com.nasa.nalog.domain.model.StatusDelivery;
import com.nasa.nalog.domain.repository.DeliveryRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CreateDeliveryService {
	private DeliveryRepository deliveryRepository;
	private FindByIdCustomerService findByIdCustomerService;
	
	@Transactional
	public Delivery execute(Delivery delivery) {
		findByIdCustomerService.findById(delivery.getCustomer().getId());
		
		delivery.setStatus(StatusDelivery.PENDENT);
		delivery.setRequestDate(OffsetDateTime.now());
		return deliveryRepository.save(delivery);
	}
}
