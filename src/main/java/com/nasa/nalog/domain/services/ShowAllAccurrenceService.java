package com.nasa.nalog.domain.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nasa.nalog.domain.exception.MyResourceNotFoundException;
import com.nasa.nalog.domain.model.Accurrence;
import com.nasa.nalog.domain.repository.AccurrenceRepository;
import com.nasa.nalog.domain.repository.DeliveryRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ShowAllAccurrenceService {
	private AccurrenceRepository accurrenceRepository;
	private DeliveryRepository deliveryRepository;
	
	@Transactional
	public List<Accurrence> execute(Long deliveryId) {
		deliveryRepository.findById(deliveryId)
				.orElseThrow(() -> new MyResourceNotFoundException("Delivery not found"));
		
		return accurrenceRepository.findByDeliveryId(deliveryId);
	}
}
