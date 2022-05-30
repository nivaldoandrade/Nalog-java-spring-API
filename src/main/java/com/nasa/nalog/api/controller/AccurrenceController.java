package com.nasa.nalog.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nasa.nalog.api.Mapper.AccurrenceMapper;
import com.nasa.nalog.api.model.request.AccurrenceRequestModel;
import com.nasa.nalog.api.model.response.AccurrenceResponseModel;
import com.nasa.nalog.domain.model.Accurrence;
import com.nasa.nalog.domain.services.CreateAccurrenceService;
import com.nasa.nalog.domain.services.ShowAllAccurrenceService;
import com.nasa.nalog.domain.services.showAccurrenceService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
public class AccurrenceController {
	private CreateAccurrenceService createAccurrenceService;
	private ShowAllAccurrenceService showAllAccurrenceService;
	private showAccurrenceService showAccurrenceService;
	
	private AccurrenceMapper accurrenceMapper;
	
	@GetMapping("/deliveries/{deliveryId}/accurrences")
	public List<Accurrence> showAll(@PathVariable Long deliveryId) {
		return showAllAccurrenceService.execute(deliveryId);
	}
	
	@GetMapping("/accurrences/{accurrenceId}")
	public AccurrenceResponseModel show(@PathVariable Long accurrenceId) {
		Accurrence accurrence = showAccurrenceService.execute(accurrenceId);
		
		return accurrenceMapper.toModel(accurrence);
	}
	
	@PostMapping("/deliveries/{deliveryId}/accurrences")
	public Accurrence create(
			@PathVariable Long deliveryId, 
			@Valid @RequestBody AccurrenceRequestModel accurrence
	) {
		return createAccurrenceService.execute(deliveryId, accurrence.getDescribe());
	}
}
