package com.mx.api.parrot.challenger.service;

import com.mx.api.parrot.challenger.exception.ApiParrotException;
import com.mx.api.parrot.challenger.model.dto.request.UserRequest;
import com.mx.api.parrot.challenger.model.dto.response.UserResponseDTO;

/**
 * Interfaz Utilizada para la creacion de un nuevo Usuario
 *
 */
public interface UserService {

	/**
	 * Metodo para la generacion de un nuevo Usuario
	 * 
	 * @param userRequest objeto con la informacion requeria para la
	 *               validacion y/o creacion de un nuevo usuario
	 * @return UserResponseDTO con la informacion de confirmacion del usuario generada
	 * 
	 * @throws {@link} ApiBookException Exception geerada en el flujo de creacion de un
	 *                          usuario
	 */
    UserResponseDTO addUser(UserRequest userRequest)throws ApiParrotException;
}