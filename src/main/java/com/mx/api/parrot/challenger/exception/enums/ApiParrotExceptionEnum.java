package com.mx.api.parrot.challenger.exception.enums;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public enum ApiParrotExceptionEnum {

	API_USER_EXIST("ERROR", INTERNAL_SERVER_ERROR, "APIUSER0001", "El usuario ya ha sido creado"),
	API_USER_NO_FOUNT("ERROR", INTERNAL_SERVER_ERROR, "APIUSER0002", "El usuario no encontrado"),
	API_LIST_PRODUCT_NO_FOUNT("ERROR", NOT_FOUND, "APILIST0001", "Lista de producto no encontrada"),
	API_LIST_NO_FOUNT("ERROR", NOT_FOUND, "APILIST0002", "Lista  no encontrada"),
	API_LIST_NO_CREATE("ERROR", NOT_FOUND, "APILIST0003", "Lista no creada"),

	API_ORDER_NO_CREATE("ERROR", INTERNAL_SERVER_ERROR, "APIORDER0001", "Orden no creada");

	private final String type;
	private final HttpStatus category;
	private final String code;
	private final String errorMessage;

}
