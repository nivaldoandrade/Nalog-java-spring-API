package com.nasa.nalog.api.Mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.nasa.nalog.api.model.response.DeliveryResponseModel;
import com.nasa.nalog.domain.model.Delivery;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class DeliveryMapper {
	private ModelMapper modelMapper;
	
	public DeliveryResponseModel toModel(Delivery delivery) {
		return modelMapper.map(delivery, DeliveryResponseModel.class);
	}
	
	public List<DeliveryResponseModel> toCollection(List<Delivery> deliveries) {
		return deliveries.stream()
			.map(delivery -> modelMapper.map(delivery, DeliveryResponseModel.class))
			.collect(Collectors.toList());
	}
}
