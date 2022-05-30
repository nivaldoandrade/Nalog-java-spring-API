package com.nasa.nalog.domain.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nasa.nalog.domain.model.Customer;
import com.nasa.nalog.domain.repository.CustomerRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class FindAllCustomers {
	private CustomerRepository customerRepository;
	
	@Transactional
	public List<Customer> execute() {
		return customerRepository.findAll();
	}
}
