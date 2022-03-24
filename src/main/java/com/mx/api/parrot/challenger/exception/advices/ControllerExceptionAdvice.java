package com.mx.api.parrot.challenger.exception.advices;

import com.mx.api.parrot.challenger.exception.ApiParrotException;
import com.mx.api.parrot.challenger.model.dto.response.GenericResponse;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerExceptionAdvice {

	@ExceptionHandler(ApiParrotException.class)
	public ResponseEntity<Object> handleException(ApiParrotException ex) {

		return new ResponseEntity<>(GenericResponse.builder()
				.status(ex.getStatus().value())
				.message(ex.getMessage())
				.code(ex.getCode())
				.build(),
				ex.getStatus());
	}
}
