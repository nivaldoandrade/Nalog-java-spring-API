package com.nasa.nalog.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nasa.nalog.domain.model.Accurrence;

public interface AccurrenceRepository extends JpaRepository<Accurrence, Long> {
	
	List<Accurrence> findByDeliveryId(Long deliveryId);

}
