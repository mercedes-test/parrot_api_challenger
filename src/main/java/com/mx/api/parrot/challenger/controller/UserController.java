package com.mx.api.parrot.challenger.controller;

import static org.springframework.http.HttpStatus.OK;

import com.mx.api.parrot.challenger.exception.ApiParrotException;
import com.mx.api.parrot.challenger.model.dto.response.ResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.api.parrot.challenger.constant.CodesHttp;
import com.mx.api.parrot.challenger.model.dto.request.UserRequest;
import com.mx.api.parrot.challenger.service.ResponseService;
import com.mx.api.parrot.challenger.service.UserService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/management/")
@RequiredArgsConstructor
@Slf4j
public class UserController {

	private final ResponseService responseService;
	private final UserService userService;

	/**
	 * Controller para la creacion de un nuevo Usuario
	 * 
	 * @param userRequest Informacion para la creacion de un nuevo Uauario
	 * @return {@link} ResponseDTO Respuesta Generica en la cual contine el status,
	 *         mensaje e informacion obtenida del flujo correspondiente
	 * @throws ApiParrotException Exception geerada en el flujo de creacion de un
	 *                          usuario
	 */
	@ApiOperation(notes = "Add User", value = "creating a new user", response = UserController.class)
	@ApiResponses(value = {
			@ApiResponse(code = CodesHttp.CODIGO_SUCCESS, message = CodesHttp.RESPUESTA_SUCCESS, response = UserController.class),
			@ApiResponse(code = CodesHttp.CODIGO_UNAUTHORIZED, message = CodesHttp.RESPUESTA_UNAUTHORIZED),
			@ApiResponse(code = CodesHttp.CODIGO_FORBIDDEN, message = CodesHttp.RESPUESTA_FORBIDDEN),
			@ApiResponse(code = CodesHttp.CODIGO_NOT_FOUND, message = CodesHttp.RESPUESTA_NOT_FOUND),
			@ApiResponse(code = CodesHttp.CODIGO_FAILURE, message = CodesHttp.RESPUESTA_FAILURE) })
	@PostMapping("users")
	public ResponseEntity<ResponseDTO> addUsers(@RequestBody UserRequest userRequest) throws ApiParrotException {
		return new ResponseEntity<>(responseService.buildResponse(userService.addUser(userRequest)), OK);
	}
}
