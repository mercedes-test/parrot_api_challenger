package com.mx.api.parrot.challenger.service.impl;

import com.mx.api.parrot.challenger.model.dto.response.ResponseDTO;
import com.mx.api.parrot.challenger.model.dto.response.GenericResponse;
import com.mx.api.parrot.challenger.service.ResponseService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ResponseServiceImpl implements ResponseService {

	@Override
	public <T> GenericResponse buildResponse(ResponseDTO responseDTO) {

		return GenericResponse.builder()
				.status(0)
				.message("SUCCESS")
				.data(responseDTO)
				.build();
	}
}
