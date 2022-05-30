package com.nasa.nalog.domain.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nasa.nalog.domain.exception.MyResourceNotFoundException;
import com.nasa.nalog.domain.model.Customer;
import com.nasa.nalog.domain.repository.CustomerRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class FindByIdCustomerService {
	
	private CustomerRepository customerRepository;
	
	@Transactional
	public Customer findById(Long customerId) {
		return customerRepository.findById(customerId)
				.orElseThrow(() -> new MyResourceNotFoundException("Customer not found"));
	} 
}
