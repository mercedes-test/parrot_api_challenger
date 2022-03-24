package com.mx.api.parrot.challenger.model.dto.request;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
public class UserRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8500942309797206677L;

	private String userName;
	private String pwd;
}