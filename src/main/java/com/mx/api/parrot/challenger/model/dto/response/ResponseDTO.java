package com.mx.api.parrot.challenger.model.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mx.api.parrot.challenger.exception.ApiParrotException;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public interface ResponseDTO {

	static final ObjectMapper ObjectMapper = new ObjectMapper();

	public default String toJsonString() throws ApiParrotException {
		try {
			return ObjectMapper.writeValueAsString(this);
		} catch (JsonProcessingException e) {
			throw new ApiParrotException(e);
		}
	}
}
