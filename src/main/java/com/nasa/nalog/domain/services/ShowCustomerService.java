package com.nasa.nalog.domain.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nasa.nalog.domain.model.Customer;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ShowCustomerService {
	
	private FindByIdCustomerService findByIdCustomerService;
	
	@Transactional
	public Customer execute(Long customerId) {
		return findByIdCustomerService.findById(customerId);
	}
}
