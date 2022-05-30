package com.nasa.nalog.domain.services;

import java.time.OffsetDateTime;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nasa.nalog.domain.exception.MyResourceNotFoundException;
import com.nasa.nalog.domain.model.Accurrence;
import com.nasa.nalog.domain.model.Delivery;
import com.nasa.nalog.domain.repository.AccurrenceRepository;
import com.nasa.nalog.domain.repository.DeliveryRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CreateAccurrenceService {
	
	private DeliveryRepository deliveryRepository;
	private AccurrenceRepository accurrenceRepository;
	
	@Transactional
	public Accurrence execute(Long deliveryId, String describe) {
		Delivery delivery = deliveryRepository.findById(deliveryId)
				.orElseThrow(() -> new MyResourceNotFoundException("Delivery not found."));
		
		delivery.isFinished();
		delivery.isCanceled();
		
		Accurrence accurrence = new Accurrence();
		
		accurrence.setDelivery(delivery);
		accurrence.setDescribe(describe);
		accurrence.setRegisterDate(OffsetDateTime.now());
		
		accurrenceRepository.save(accurrence);
		
		return accurrence;
	}
}
