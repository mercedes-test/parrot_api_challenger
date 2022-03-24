package com.mx.api.parrot.challenger.service.impl;

import java.util.Objects;
import java.util.Optional;

import com.mx.api.parrot.challenger.exception.ApiParrotException;
import com.mx.api.parrot.challenger.exception.enums.ApiParrotExceptionEnum;
import com.mx.api.parrot.challenger.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.mx.api.parrot.challenger.model.dto.request.UserRequest;
import com.mx.api.parrot.challenger.model.dto.response.UserResponseDTO;
import com.mx.api.parrot.challenger.model.entity.UserEntity;
import com.mx.api.parrot.challenger.service.UserService;

import lombok.RequiredArgsConstructor;

/**
 * Implemantacion Utilizada para la creacion de un nuevo Usuario
 *
 */
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;

	private final BCryptPasswordEncoder bcryptPasswordEncoder;

	/**
	 * Metodo para la generacion de un nuevo Usuario
	 * 
	 * @param userRequest objeto con la informacion requeria para la validacion y/o
	 *                    creacion de un nuevo usuario
	 * @return UserResponseDTO con la informacion de confirmacion del usuario
	 *         generada
	 * 
	 * @throws {@link} ApiParrotException Exception geerada en el flujo de creacion de
	 *                 un usuario
	 */
	@Override
	public UserResponseDTO addUser(UserRequest userRequest) throws ApiParrotException {

		UserEntity userEntity = userRepository.findByUsername(userRequest.getUserName());

		if(Objects.nonNull(userEntity)){
		 throw  new ApiParrotException(ApiParrotExceptionEnum.API_USER_EXIST);
		}

		userRepository.save(new UserEntity().setUsername(userRequest.getUserName())
				.setPassword(bcryptPasswordEncoder.encode(userRequest.getPwd())));

		return UserResponseDTO.builder().userName(userRequest.getUserName()).build();
	}

}