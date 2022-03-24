package com.mx.api.parrot.challenger.model.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.io.Serializable;

@Builder
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserResponseDTO implements ResponseDTO, Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = -898531581750694124L;
	
	String userName;
}
