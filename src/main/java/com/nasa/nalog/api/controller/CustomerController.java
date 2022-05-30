package com.nasa.nalog.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.nasa.nalog.domain.model.Customer;
import com.nasa.nalog.domain.services.CreateCustomerService;
import com.nasa.nalog.domain.services.DeleteCustomerService;
import com.nasa.nalog.domain.services.FindAllCustomers;
import com.nasa.nalog.domain.services.UpdateCustomerService;
import com.nasa.nalog.domain.services.ShowCustomerService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/customers")
public class CustomerController {
	
	private CreateCustomerService createCustomerService;
	private FindAllCustomers findAllCustomers;
	private UpdateCustomerService updateCustomerService;
	private ShowCustomerService showCustomerService;
	private DeleteCustomerService deleteCustomerService;
	
	@GetMapping
	public List<Customer> findAll() {
		return findAllCustomers.execute();
	}
	
	@GetMapping("/{customerId}")
	public Customer show(@PathVariable Long customerId) {
		return showCustomerService.execute(customerId);
	}
	
	@PostMapping
	public Customer create(@Valid @RequestBody Customer customer) {
		return createCustomerService.execute(customer);
	}
	
	@PutMapping("/{customerId}")
	public Customer update(@PathVariable Long customerId, @Valid @RequestBody Customer customer) {
		return updateCustomerService.execute(customerId, customer);
	}
	
	@DeleteMapping("/{customerId}")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long customerId) {
		deleteCustomerService.execute(customerId);
	}

}
