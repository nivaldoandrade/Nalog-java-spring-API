package com.nasa.nalog.domain.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nasa.nalog.domain.exception.MyResourceNotFoundException;
import com.nasa.nalog.domain.model.Accurrence;
import com.nasa.nalog.domain.repository.AccurrenceRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class showAccurrenceService {
	private AccurrenceRepository accurrenceRepository;
	
	@Transactional
	public Accurrence execute(Long accurrenceId) {
		return accurrenceRepository.findById(accurrenceId)
				.orElseThrow(() -> new MyResourceNotFoundException("Accurrence not found."));
	}
}
