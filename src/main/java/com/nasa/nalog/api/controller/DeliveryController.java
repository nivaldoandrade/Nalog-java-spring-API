package com.nasa.nalog.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.nasa.nalog.api.Mapper.DeliveryMapper;
import com.nasa.nalog.api.model.response.DeliveryResponseModel;
import com.nasa.nalog.domain.model.Delivery;
import com.nasa.nalog.domain.services.CancelDeliveryService;
import com.nasa.nalog.domain.services.CreateDeliveryService;
import com.nasa.nalog.domain.services.FindAllDeliveryService;
import com.nasa.nalog.domain.services.FinishDeliveryService;
import com.nasa.nalog.domain.services.ShowDeliveryService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/deliveries")
public class DeliveryController {
	private CreateDeliveryService createDeliveryService;
	private ShowDeliveryService showDeliveryService;
	private FindAllDeliveryService findAllDeliveryService;
	private FinishDeliveryService finishDeliveryService;
	private CancelDeliveryService cancelDeliveryService;
	
	private DeliveryMapper deliveryMapper;
	
	@GetMapping
	public List<DeliveryResponseModel> showAll() {
		List<Delivery> deliveries = findAllDeliveryService.execute();
		
		return deliveryMapper.toCollection(deliveries);
	}
	
	@GetMapping("/{deliveryId}")
	public DeliveryResponseModel show(@PathVariable Long deliveryId) {
		Delivery delivery = showDeliveryService.execute(deliveryId);
		
		return deliveryMapper.toModel(delivery);
	}
	
	@PostMapping
	public Delivery create(@Valid @RequestBody Delivery delivery) {
		return createDeliveryService.execute(delivery);
	}
	

	@PutMapping("/{deliveryId}/finishing")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void finishStatus(@PathVariable Long deliveryId) {
		finishDeliveryService.execute(deliveryId);
	}
	
	@PutMapping("/{deliveryId}/canceling")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void cancelStatus(@PathVariable Long deliveryId) {
		cancelDeliveryService.execute(deliveryId);
	} 

}
