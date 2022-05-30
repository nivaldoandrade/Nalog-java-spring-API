package com.nasa.nalog.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nasa.nalog.domain.model.Delivery;

public interface DeliveryRepository extends JpaRepository<Delivery, Long> {
	
}
