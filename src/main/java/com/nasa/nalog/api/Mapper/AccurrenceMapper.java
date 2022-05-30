package com.nasa.nalog.api.Mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.nasa.nalog.api.model.response.AccurrenceResponseModel;
import com.nasa.nalog.domain.model.Accurrence;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class AccurrenceMapper {
	private ModelMapper modelMapper;
	
	public AccurrenceResponseModel toModel(Accurrence accurrence) {
		return modelMapper.map(accurrence, AccurrenceResponseModel.class);
	}
}
