package com.nasa.nalog.domain.services;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nasa.nalog.domain.exception.MyResourceNotFoundException;
import com.nasa.nalog.domain.model.Customer;
import com.nasa.nalog.domain.repository.CustomerRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CreateCustomerService {
	
	private CustomerRepository customerRepository;
	
	@Transactional
	public Customer execute(Customer customer) {
		Optional<Customer> customerEmailExist = customerRepository.findByEmail(customer.getEmail());
		
		if(customerEmailExist.isPresent()) {
			throw new MyResourceNotFoundException("E-mail already use");
		}
		
		return customerRepository.save(customer);
	}
}
