package com.nasa.nalog.domain.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nasa.nalog.domain.exception.MyResourceBadRequestException;
import com.nasa.nalog.domain.model.Customer;
import com.nasa.nalog.domain.repository.CustomerRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class UpdateCustomerService {
	
	private CustomerRepository customerRepository;
	private FindByIdCustomerService findByIdCustomerService;
	
	@Transactional
	public Customer execute(Long customerId, Customer customer) {
		findByIdCustomerService.findById(customerId);
			
		boolean customerEmailExist = customerRepository.findByEmail(customer.getEmail())
				.stream()
				.anyMatch(c -> !(c.getId().equals(customerId)));
		
		if(customerEmailExist) {
			throw new MyResourceBadRequestException("E-mail already use");
		}
		
		customer.setId(customerId);
		return customerRepository.save(customer);
	}
}
