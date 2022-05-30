package com.nasa.nalog.domain.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nasa.nalog.domain.repository.CustomerRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class DeleteCustomerService {

	private CustomerRepository customerRepository;
	private FindByIdCustomerService findByIdCustomerService;
	
	@Transactional
	public void execute(Long customerId) {
		findByIdCustomerService.findById(customerId);
		
		customerRepository.deleteById(customerId);
	}
}
