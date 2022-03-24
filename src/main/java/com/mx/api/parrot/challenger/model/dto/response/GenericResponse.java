package com.mx.api.parrot.challenger.model.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
@Builder
public class GenericResponse implements ResponseDTO, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2768125462826260946L;
	
	@JsonProperty("status")
	private int status;
	@JsonProperty("message")
    private String message;
	@JsonProperty("code")
    private String code;
	@JsonProperty("data")
    private ResponseDTO data;

}